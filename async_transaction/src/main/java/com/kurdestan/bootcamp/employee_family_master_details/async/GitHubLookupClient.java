package com.kurdestan.bootcamp.employee_family_master_details.async;


import com.kurdestan.bootcamp.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users", url = "https://api.github.com/users/", configuration = FeignConfig.class)

public interface GitHubLookupClient {
    @GetMapping(value = "/{user}")
    User getUser(@PathVariable String user);
}
