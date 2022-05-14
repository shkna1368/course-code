package com.mapsa.qualifier.prim;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StudentServiceSecond implements IStudentService {

    @Override
    public void add() {
        System.out.println(" add in StudentServiceSecond");
    }

}
