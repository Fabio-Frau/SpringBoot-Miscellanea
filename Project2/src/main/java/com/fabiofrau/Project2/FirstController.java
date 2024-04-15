package com.fabiofrau.Project2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my First Controller";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request accepted and message is " + message;
    }

    @PostMapping("/order")
    public String order(@RequestBody Order order) {
        return "Requested order: " + order.toString();
    }

    @PostMapping("/order-record")
    public String postRecord(@RequestBody OrderRecord order) {
        return "Requested order: " + order.toString();
    }

    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName) {
        return "my value = " + userName;
    }

    @GetMapping("/hello-req-param")
    public String reqParam(
            @RequestParam("user-name") String userName,
            @RequestParam("last-name") String lastName
    ) {
        return "my value = " + userName + " " + lastName;
    }

}
