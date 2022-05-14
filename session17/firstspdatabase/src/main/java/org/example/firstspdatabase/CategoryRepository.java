package org.example.firstspdatabase;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends PagingAndSortingRepository<Category,Long> {
}
