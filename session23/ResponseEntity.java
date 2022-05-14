package com.saba.carmanagment;

import com.saba.carmanagment.dto.CarDTO;
import com.saba.carmanagment.dto.PagingData;
import com.saba.carmanagment.entity.Car;
import com.saba.carmanagment.mapper.CarMapper;
import com.saba.carmanagment.service.ICarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/car")

public class Controller {
private      ICarService carService;

    private     CarMapper carMapper;

    public Controller(ICarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @ApiOperation(value = "Add or insert car")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added successfully"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 409, message = "It is duplicate"),
            @ApiResponse(code = 500, message = "Server error")
    })

    @PostMapping(value = "/")
    public ResponseEntity<Void> addCar(@RequestBody @Valid CarDTO carDTO){
Car car=carMapper.toCar(carDTO);
carService.addNewCar( car);
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }
@PutMapping(value = "/")
    public ResponseEntity<Void> updateCar(@RequestBody @Valid CarDTO carDTO){
Car car=carMapper.toCar(carDTO);
carService.updateNewCar( car);
        return ResponseEntity.status(HttpsURLConnection.HTTP_OK).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarDTO>> getAllData(){
        List<Car> cars = carService.getAll();
        List<CarDTO> carDTOS = carMapper.toCarDTOs(cars);

        return ResponseEntity.ok(carDTOS);

    }

  @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable(name = "id") Long id){
  Car car=  carService.getById(id);
CarDTO carDTO=carMapper.toCarDTO(car);


      return ResponseEntity.ok(carDTO);
    }


  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id){
   carService.deletById(id);


      return ResponseEntity.status(HttpsURLConnection.HTTP_OK).build();
    }

    @GetMapping("/getAll/{page}/{size}")
    public ResponseEntity<PagingData> getAll(@PathVariable("page") int page, @PathVariable("size") int size) {

        Page<Car> carPages = carService.getAll(page, size);
     List<Car>  cars=  carPages.getContent();
     List<CarDTO>  carDTOs=  carMapper.toCarDTOs(cars);



   Integer totalPage=  carPages.getTotalPages();
        Long totalElements = carPages.getTotalElements();


        PagingData pagingData=new PagingData();
        pagingData.setData(carDTOs);
        pagingData.setCurrengPage(page);
        pagingData.setTotalPage(totalPage);
        pagingData.setTotalElement(totalElements);

        return ResponseEntity.ok(pagingData);
    }


}
