package com.mapsa.qualifier.inheritance.onetableperclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MotorCycleRepository extends JpaRepository<Motorcycle, Long>{



}