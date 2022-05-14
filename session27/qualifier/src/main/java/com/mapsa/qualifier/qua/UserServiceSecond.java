package com.mapsa.qualifier.qua;

import org.springframework.stereotype.Service;

@Service("userServiceSecond")
public class UserServiceSecond implements  IUserService{
    @Override
    public void add(String name, String family) {
        System.out.println("add in UserServiceSecond");
    }

    @Override
    public String get(Long id) {
        System.out.println("get in UserServiceSecond");

        return String.valueOf(id);
    }
}
