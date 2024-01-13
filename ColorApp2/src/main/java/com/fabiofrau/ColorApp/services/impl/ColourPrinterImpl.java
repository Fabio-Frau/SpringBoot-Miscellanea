package com.fabiofrau.ColorApp.services.impl;

import com.fabiofrau.ColorApp.services.BluePrinter;
import com.fabiofrau.ColorApp.services.ColourPrinter;
import com.fabiofrau.ColorApp.services.GreenPrinter;
import com.fabiofrau.ColorApp.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class ColourPrinterImpl implements ColourPrinter {

    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greePrinter;

    public ColourPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter,
                             GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greePrinter = greenPrinter;
    }

    @Override
    public String print() {
        return String.join(", ", redPrinter.print(),
                bluePrinter.print(), greePrinter.print());
    }

}
