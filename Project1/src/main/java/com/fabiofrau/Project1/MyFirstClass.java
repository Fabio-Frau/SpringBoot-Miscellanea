package com.fabiofrau.Project1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyFirstClass {

    private String myVar;


    public String sayHello() {
        return "Hello from MyFirstClass ==> myVar = " + myVar;
    }

}
