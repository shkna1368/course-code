package com.saba.carmanagment.mapper;

import com.saba.carmanagment.dto.CarDTO;
import com.saba.carmanagment.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T04:28:39+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO toCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setId( car.getId() );
        carDTO.setModel( car.getModel() );
        carDTO.setSpeed( car.getSpeed() );

        return carDTO;
    }

    @Override
    public Car toCar(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carDTO.getId() );
        car.setModel( carDTO.getModel() );
        car.setSpeed( carDTO.getSpeed() );

        return car;
    }

    @Override
    public List<CarDTO> toCarDTOs(List<Car> cars) {
        if ( cars == null ) {
            return null;
        }

        List<CarDTO> list = new ArrayList<CarDTO>( cars.size() );
        for ( Car car : cars ) {
            list.add( toCarDTO( car ) );
        }

        return list;
    }
}
