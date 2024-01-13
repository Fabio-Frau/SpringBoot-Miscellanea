package com.fabiofrau.ColorApp.services.impl;

import com.fabiofrau.ColorApp.services.GreenPrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SpanishGreenPrinter implements GreenPrinter {

    @Override
    public String print() {
        return "verde";
    }

}
