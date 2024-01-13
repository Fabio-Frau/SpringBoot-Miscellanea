package com.fabiofrau.ColorApp.services.impl;

import com.fabiofrau.ColorApp.services.BluePrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SpanishBluePrinter implements BluePrinter {

    @Override
    public String print() {
        return "azul";
    }

}
