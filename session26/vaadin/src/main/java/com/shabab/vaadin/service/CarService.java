package com.shabab.vaadin.service;

import com.shabab.vaadin.dto.CarCategory;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {


    @Autowired
    CarServiceProxy carServiceProxy;



  public   List<CarCategory> getAllCtegories(){



      try {


          return carServiceProxy.getAllCat();


      }

      catch (FeignException e){

  /*        String message = messageSource.getMessage("unavailable_mdms_post_external_service", null, Locale.ENGLISH);
          log.error("mdms api calling error:"+e.status()+"-"+message);
          throw new ExternalApiException(e.status()+"-"+message);*/
          throw new RuntimeException("error");
      }

  }



public void save(CarCategory category){

      carServiceProxy.save(category);
}





}
