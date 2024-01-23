package com.fabiofrau.CORS.Setup.Demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins = {"http://localhost"})
@RestController
public class UserController {


    @GetMapping("/me")
    public String me() {
        return "Fabio";
    }

}
