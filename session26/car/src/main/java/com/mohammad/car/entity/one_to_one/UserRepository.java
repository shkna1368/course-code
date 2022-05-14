package com.mohammad.car.entity.one_to_one;

import com.mohammad.car.entity.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
