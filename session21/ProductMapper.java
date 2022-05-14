package com.nicico.hse.ppe.product;

import com.nicico.hse.base_information_value.BaseInformationValueMapper;
import com.nicico.hse.ppe.category.Category;
import com.nicico.hse.ppe.category.CategoryDTO;
import com.nicico.hse.ppe.category.CategoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, BaseInformationValueMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "lastAllocationDate", target = "lastAllocationDate", ignore = false, qualifiedByName = "productTimestampToDates"),
    })
    Product toProduct(ProductDTO productDTO);

    @Mappings({
            @Mapping(source = "lastAllocationDate", target = "lastAllocationDate", ignore = false, qualifiedByName = "productDateToTimestamps"),
            @Mapping(target = "category.parent", ignore = true),
            //@Mapping(target = "category.createdDate", ignore = true),
            @Mapping(target = "accountType.baseInformationGroup", ignore = true),
            @Mapping(target = "recipientType.baseInformationGroup", ignore = true),
            @Mapping(target = "consumerProductType.baseInformationGroup", ignore = true),
            @Mapping(target = "productExpiringType.baseInformationGroup", ignore = true),
            @Mapping(target = "defectiveDelivery.baseInformationGroup", ignore = true),
            @Mapping(target = "consumptionPeriodUnit.baseInformationGroup", ignore = true),
            @Mapping(target = "commodityUnitType.baseInformationGroup", ignore = true),
    })
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    @Named("productTimestampToDates")
    default Date toDate(Long timestamp) {
        if (timestamp != null)
            return new Date(timestamp);
        else
            return null;
    }

    @Named("productDateToTimestamps")
    default Long toTimestamps(Date date) {
        if (date != null)
            return date.getTime();
        else
            return null;
    }

}
