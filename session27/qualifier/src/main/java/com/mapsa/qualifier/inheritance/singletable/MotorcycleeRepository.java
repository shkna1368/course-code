package com.mapsa.qualifier.inheritance.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MotorcycleeRepository extends JpaRepository<Motorcyclee, Long>{



}