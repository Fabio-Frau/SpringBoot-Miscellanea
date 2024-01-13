package com.fabiofrau.ColorApp.services.impl;

import com.fabiofrau.ColorApp.services.BluePrinter;
import org.springframework.stereotype.Component;


public class EnglishBluePrinter implements BluePrinter {

    @Override
    public String print() {
        return "blue";
    }

}
