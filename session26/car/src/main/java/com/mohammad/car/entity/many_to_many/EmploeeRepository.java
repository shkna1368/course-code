package com.mohammad.car.entity.many_to_many;

import com.mohammad.car.entity.CarCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploeeRepository extends PagingAndSortingRepository <Employee,Long>{


}
