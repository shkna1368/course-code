package com.nicico.hse.ppe.category;

import com.nicico.copper.common.domain.criteria.SearchUtil;
import com.nicico.copper.common.dto.search.SearchDTO;
import com.nicico.hse.base_information_group.BaseInformationGroup;
import com.nicico.hse.common.HseSearch;
import com.nicico.hse.exception.BadRequestException;
import com.nicico.hse.exception.BusinessException;
import com.nicico.hse.exception.ConflictException;
import com.nicico.hse.exception.NotFoundException;
import com.nicico.hse.ppe.product.IProductService;
import com.nicico.hse.ppe.product.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Pattern;

@Service
@Slf4j
public class CategoryService implements ICategoryService {

    private final MessageSource messageSource;

    private final CategoryRepository categoryRepository;
    private final IProductService productService;

    public CategoryService(MessageSource messageSource, CategoryRepository categoryRepository, @Lazy IProductService productService) {
        this.messageSource = messageSource;
        this.categoryRepository = categoryRepository;
        this.productService = productService;

    }



    @Caching(evict = {
            @CacheEvict(value = "activeTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "inActiveTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "allTreeNodeByParent", allEntries = true),

    })
    @Override
    public Category save(Category category) {
        Category parent = null;
        //آیا پدر ست شده است؟
        if (category.getParent() != null) {
            parent = getById(category.getParent().getId());
            category.setParent(parent);
        } else {
            throw new BadRequestException(messageSource.getMessage("tree_parent_not_specified", null, Locale.ENGLISH));
        }
        //آیا طبقه پدر وجود دارد
        if (productService.categoryExist(parent.getId())) {
            throw new AccessDeniedException(messageSource.getMessage("not_exists_node", null, Locale.ENGLISH));
        }
        //آیا طبقه پدر فعال است؟
        if (Boolean.FALSE == parent.getIsActive()) {
            throw new AccessDeniedException(messageSource.getMessage("parent_node_is_inactive", null, Locale.ENGLISH));
        }
        //آیا طبقه پدر آخرین نود است؟
        if (Boolean.TRUE == category.getParent().getIsLastLevelNode()) {
            throw new AccessDeniedException(messageSource.getMessage("not_allowed_add_node_is_last_level_node", null, Locale.ENGLISH));
        }

        String englishTitle = category.getEnglishTitle();
        //اگر نام انگلیسی طبقه وارد شده است چک شود تکراری نباشد
        if (null != englishTitle || !englishTitle.equals("")) {
            checkingEnglishTitleJustLetter(englishTitle);
            checkingDuplicateEnglishTitle(englishTitle, category.getParent().getId(), null);
        }
        String parentFullTitle=getFullTitle(category.getParent().getId());
        if(parentFullTitle.equals(""))
            category.setFullPersianTitle(category.getPersianTitle().trim());
        else
            category.setFullPersianTitle((parentFullTitle + " / " + category.getPersianTitle()).trim());

        //category.setFullPersianTitle((getFullTitle(category.getParent().getId()) + " / " + category.getPersianTitle()).trim());
        category.setLevel(category.getParent().getLevel() + 1);

        //به صورت پیشفرض تا وقتی که کالا روی آن تعریف نشده است آخرین نود درخت نیست
        category.setIsLastLevelNode(false);

        //ذخیره طبقه
        Long id = categoryRepository.save(category).getId();
        return getById(id);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "activeTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "inActiveTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "allTreeNodeByParent", allEntries = true),
    })

    @Transactional
    public Category update(Category category) {
        if (null == category || category.getParent() == null) {
            throw new BadRequestException(messageSource.getMessage("tree_parent_not_specified", null, Locale.ENGLISH));
        }
        String englishTitle = category.getEnglishTitle();
        if (!ObjectUtils.isEmpty(englishTitle) ) {
//        if (null != englishTitle || !englishTitle.equals("")) {
            checkingEnglishTitleJustLetter(englishTitle);
            checkingDuplicateEnglishTitle(englishTitle, category.getParent().getId(), category.getId());

        }
        Category savedCategory = null;
        Category lastCategory = getById(category.getId());
        boolean alreadyInUse = checkCategoryAlreadyInUsed(lastCategory);
        lastCategory.setDescription(category.getDescription());
        if (!alreadyInUse) {

            if (lastCategory.getEnglishTitle()!=category.getEnglishTitle()) {
                lastCategory.setEnglishTitle(category.getEnglishTitle());

            }
            if (!lastCategory.getPersianTitle().equals(category.getPersianTitle())) {
                lastCategory.setPersianTitle(category.getPersianTitle());
                String parentFullTitle=getFullTitle(lastCategory.getParent().getId());
                if(parentFullTitle.equals(""))
                    lastCategory.setFullPersianTitle(category.getPersianTitle().trim());
                else
                    lastCategory.setFullPersianTitle((parentFullTitle + " / " + category.getPersianTitle()).trim());
                savedCategory = categoryRepository.save(lastCategory);
                updateChildrenFullTitle(category.getId());
            }
        }
        if (lastCategory.getIsActive() != category.getIsActive()) {
            lastCategory.setIsActive(category.getIsActive());
            if (Boolean.FALSE == category.getIsActive()) {
                savedCategory = categoryRepository.save(lastCategory);
                inActiveChildsCategory(category.getId());

            }

        } else {
            savedCategory = categoryRepository.save(lastCategory);


        }
        return savedCategory;
    }

    @Override
    public Category getById(Long id) {		

    /*    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        request.getHeader("host")*/
        Optional<Category> optionalCatEqSize = categoryRepository.findById(id);
        if (!optionalCatEqSize.isPresent()) {
            log.error("Category.getById() :", messageSource.getMessage("not_found_id", null, Locale.ENGLISH));
            throw new NotFoundException("طبقه یندی با این شناسه موجود نیست");
        }
        log.info("successful run  Category.getById() ");
        return optionalCatEqSize.get();

    }
    
	@Caching(evict = {
            @CacheEvict(value = "activeTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "inActiveTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "allTreeNodeByParent", allEntries = true),

    })
    @Override
    public void setToLastNode(Long id, Boolean isLastNode) {
        Category category = getById(id);
        category.setIsLastLevelNode(isLastNode);
        categoryRepository.save(category);
    }

    @Override
    @Cacheable(value = "allTreeNodeByParent",key = "#parentId")
    public List<Category> getAllChildsByParent(Long parentId) {
        return fillHasChild( categoryRepository.findAllByParent_Id(parentId));
    }

    @Override
    @Cacheable(value = "activeTreeNodeByParent",key = "#parentId")
    public List<Category> getActiveChildsByParent(Long parentId) {
        return fillHasChild(categoryRepository.findAllByParent_IdAndIsActive(parentId,true));
    }

    @Override
    @Cacheable(value = "inActiveTreeNodeByParent",key = "#parentId")
    public List<Category> getInActiveChildsByParent(Long parentId) {
        return fillHasChild(categoryRepository.findAllByParent_IdAndIsActive(parentId,false));
    }



    @Override
    public Category getRoot() {
        return categoryRepository.findByParentIsNull();
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public boolean hasSubCategory(Long catId) {
        if (categoryRepository.countAllByParent_Id(catId) > 0)
            return true;
        return false;
    }

    @Override
    public Long countSubCategory(Long catId) {
        return categoryRepository.countAllByParent_Id(catId);

    }


    @Caching(evict = {
            @CacheEvict(value = "activeTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "inActiveTreeNodeByParent", allEntries = true),
            @CacheEvict(value = "allTreeNodeByParent", allEntries = true),

    })
    @Override
    public void deleteById(Long id) {
        Category category = getById(id);
        boolean alredyInUsed = checkCategoryAlreadyInUsed(category);
        if (alredyInUsed) {
            throw new AccessDeniedException(messageSource.getMessage("inused_not_allowed_delete", null, Locale.ENGLISH));

        }
        categoryRepository.deleteById(id);

    }

    @Override
    public SearchDTO.SearchRs<Category> search(SearchDTO.SearchRq filter) throws InvalidDataAccessApiUsageException {
        SearchDTO.SearchRs<Category> n= HseSearch.search(categoryRepository, filter);
        List<Category> categories = fillHasChild(n.getList());
        n.setList(categories);
        return n;
    }

    @Override
    public String getFullTitle(Long catEqSizeId) {
        List<String> fullTitleList = new ArrayList<>();
        StringBuilder t = new StringBuilder();
        String fulltitle = categoryRepository.getFullPersianTitle(catEqSizeId).trim();
        String[] titleArray = fulltitle.split("#");
        fullTitleList = Arrays.asList(titleArray);
        Collections.reverse(fullTitleList);
        fullTitleList.forEach((item) -> {
            if (!item.trim().equals(""))
                t.append(item).append(" / ");
        });
        if (t.toString().trim().length()>0) {
            String result = t.toString().trim().trim().substring(0, t.toString().length() - 3);
//        return t.toString().trim().trim();
            return result.trim();
        }
        else return "";
    }

    public void checkingEnglishTitleJustLetter(String englishTitle) {
        if (!ObjectUtils.isEmpty(englishTitle)) {
            String regx = "^[a-zA-z\\s]+$";
            Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
            if (!pattern.matcher(englishTitle).find()) {
                throw new BusinessException(messageSource.getMessage("english_title_only_letters", null, Locale.ENGLISH));

            }
        }
    }

    public void checkingDuplicateEnglishTitle(String englishTitle, Long parentId, Long categoryId) {
        long count = 0;
        if (null == categoryId) {
            count = categoryRepository.countAllByParent_IdAndEnglishTitleIgnoreCase(parentId, englishTitle);

        } else {
            count = categoryRepository.countAllByParent_IdAndEnglishTitleIgnoreCaseAndIdNot(parentId, englishTitle, categoryId);

        }
        if (count > 0) {
            throw new ConflictException(messageSource.getMessage("duplicate_english_title", null, Locale.ENGLISH));
        }
    }

    private boolean checkCategoryAlreadyInUsed(Category category) {
        //
        long categoryChildCount = categoryRepository.countAllByParent_Id(category.getId());
        if (categoryChildCount > 0) {
            return true;
        }
        if (productService.categoryExist(category.getId())) {
            return true;
        }
        return false;

    }

    private void updateChildrenFullTitle(Long categoryId) {
        List<Long> childrenIds = categoryRepository.findChildrenHierarchyIdById(categoryId);
        for (int i = 0; i < childrenIds.size(); i++) {
            Long id = childrenIds.get(i);
            if (!id.equals(categoryId)) {
                Category category = getById(id);
                category.setFullPersianTitle((getFullTitle(category.getParent().getId()) + " / " + category.getFullPersianTitle()).trim());
                categoryRepository.save(category);
            }
        }

    }

    private void inActiveChildsCategory(Long categoryId) {
        List<Long> childrenIds = categoryRepository.findChildrenHierarchyIdById(categoryId);
        for (int i = 0; i < childrenIds.size(); i++) {
            Long id = childrenIds.get(i);
            if (id != categoryId) {
                Category category = getById(id);
                category.setIsActive(false);
                categoryRepository.save(category);
            }
        }

    }

    private List<Category> fillHasChild(List<Category> categoryList){
        categoryList.forEach(category -> {
            //category.setHasChild(checkCategoryAlreadyInUsed(category));
            category.setHasChild(hasSubCategory(category.getId()));
        });
        return categoryList;
    }

}
