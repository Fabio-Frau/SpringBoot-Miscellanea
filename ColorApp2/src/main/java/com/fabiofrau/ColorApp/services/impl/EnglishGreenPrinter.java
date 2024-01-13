package com.fabiofrau.ColorApp.services.impl;

import com.fabiofrau.ColorApp.services.GreenPrinter;
import org.springframework.stereotype.Component;


public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public String print() {
        return "green";
    }

}
