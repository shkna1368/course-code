package com.saba.carmanagment.mapper;

import com.saba.carmanagment.dto.CarDTO;
import com.saba.carmanagment.entity.Car;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {


    CarDTO toCarDTO(Car car);


    Car toCar(CarDTO carDTO);


    List<CarDTO> toCarDTOs(List<Car> cars);

}