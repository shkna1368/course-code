package com.mapsa.qualifier.inheritance.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarrRepository extends JpaRepository<Carr, Long>{



}