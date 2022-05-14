package com.mohammad.car.entity.one_to_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class UserProfileSeeder implements ApplicationRunner {


    @Autowired
    UserRepository userRepository;


    @Autowired
    UserProfileRepository userProfileRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (userProfileRepository.count() == 0) {


            User user = new User();
            user.setEmail("shabab@gamail.com");
            user.setFirstName("shabab");
            user.setLastName("koohi");
            user.setPassword("123456");

            User savedUser = userRepository.save(user);

            UserProfile userProfile = new UserProfile();
            userProfile.setUser(savedUser);
            userProfile.setAddress1("add1");
            userProfile.setAddress2("adr2");
            userProfile.setCity("city1");
            userProfile.setCountry("country1");
            userProfile.setGender(Gender.MALE);
            userProfile.setDateOfBirth(new Date());
            userProfile.setPhoneNumber("656598899");
            userProfile.setState("state1");
            userProfile.setZipCode("123456987");

            UserProfile savedUserProfile = userProfileRepository.save(userProfile);
            System.out.println("user pr id:" + savedUserProfile.getId());

        }
        Optional<User> usr = userRepository.findById(1l);


        Optional<UserProfile> userProfile = userProfileRepository.findById(1l);


        System.out.println(1);


    }
}
