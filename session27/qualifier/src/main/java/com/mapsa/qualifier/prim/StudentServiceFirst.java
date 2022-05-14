package com.mapsa.qualifier.prim;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceFirst implements IStudentService{

    @Override
    public void add() {
        System.out.println(" add in StudentServiceFirst");
    }
}
