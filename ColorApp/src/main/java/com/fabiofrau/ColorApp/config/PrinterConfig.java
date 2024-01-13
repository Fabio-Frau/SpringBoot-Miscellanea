package com.fabiofrau.ColorApp.config;

import com.fabiofrau.ColorApp.services.BluePrinter;
import com.fabiofrau.ColorApp.services.ColourPrinter;
import com.fabiofrau.ColorApp.services.GreenPrinter;
import com.fabiofrau.ColorApp.services.RedPrinter;
import com.fabiofrau.ColorApp.services.impl.ColourPrinterImpl;
import com.fabiofrau.ColorApp.services.impl.EnglishBluePrinter;
import com.fabiofrau.ColorApp.services.impl.EnglishGreenPrinter;
import com.fabiofrau.ColorApp.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter() {
        return new EnglishBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new EnglishRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new EnglishGreenPrinter();
    }

    @Bean
    public ColourPrinter colourPrinter(BluePrinter bluePrinter, RedPrinter redPrinter,
                                       GreenPrinter greenPrinter) {
        return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }

}
