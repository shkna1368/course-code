package com.mapsa.qualifier.qua;

import org.springframework.stereotype.Service;

@Service("userServiceFirst")
public class UserServiceFirst implements  IUserService{
    @Override
    public void add(String name, String family) {
        System.out.println("add in UserServiceFirst");
    }

    @Override
    public String get(Long id) {
        System.out.println("get in UserServiceFirst");

        return String.valueOf(id);
    }
}
