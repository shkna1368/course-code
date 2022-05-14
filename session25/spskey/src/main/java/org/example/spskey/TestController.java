package org.example.spskey;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/users")

public class TestController {
    @GetMapping("/status/check")
    public String status() {
        return "working";
    }

    @RolesAllowed("admin")
    @GetMapping("/admin")
    public String status1() {
        return "admin";
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }

  @RolesAllowed("superadmin")
    @GetMapping("/superadmin")
    public String status2() {
        return "superadmin";
    }



}
