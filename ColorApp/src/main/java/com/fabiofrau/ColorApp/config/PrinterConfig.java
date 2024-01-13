package com.fabiofrau.ColorApp.config;

import com.fabiofrau.ColorApp.services.BluePrinter;
import com.fabiofrau.ColorApp.services.ColourPrinter;
import com.fabiofrau.ColorApp.services.GreenPrinter;
import com.fabiofrau.ColorApp.services.RedPrinter;
import com.fabiofrau.ColorApp.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

//    @Bean
//    public BluePrinter bluePrinter() {
//        return new EnglishBluePrinter();
//    }
//
//    @Bean
//    public RedPrinter redPrinter() {
//        return new EnglishRedPrinter();
//    }
//
//    @Bean
//    public GreenPrinter greenPrinter() {
//        return new EnglishGreenPrinter();
//    }

    @Bean
    public BluePrinter bluePrinter() {
        return new SpanishBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new SpanishRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new SpanishGreenPrinter();
    }

    @Bean
    public ColourPrinter colourPrinter(BluePrinter bluePrinter, RedPrinter redPrinter,
                                       GreenPrinter greenPrinter) {
        return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }

}
