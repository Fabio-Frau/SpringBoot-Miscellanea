package com.fabiofrau.ColorApp.services.impl;

import com.fabiofrau.ColorApp.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print() {
        return "red";
    }

}
