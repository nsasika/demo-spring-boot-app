package com.example.demo.resources;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerResource {

    @PostMapping("/add")
    public String registerUser(@RequestBody Map<String, Object> userMap){
    String firstName = (String) userMap.get("firstName");
    String lastName = (String) userMap.get("lastName");
    String email = (String) userMap.get("email");

    return firstName+ " "+ lastName+ " "+email;
    }

    @GetMapping("/list")
    public String getCustomers(){
        return "getCustomer";
    }
}
