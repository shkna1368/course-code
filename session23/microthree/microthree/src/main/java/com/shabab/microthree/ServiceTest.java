package com.shabab.microthree;

import org.springframework.stereotype.Service;

@Service
public class ServiceTest {

public String test(Long id){
    if(id==5){

        throw new NotfoundException("Not found");
    }
    else if(id == 6){
        throw new ConflictException("tekrari");

    }
return "hi from service";

}

}
