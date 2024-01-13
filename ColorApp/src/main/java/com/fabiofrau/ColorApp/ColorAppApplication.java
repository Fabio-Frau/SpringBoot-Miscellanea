package com.fabiofrau.ColorApp;

import com.fabiofrau.ColorApp.services.ColourPrinter;
import com.fabiofrau.ColorApp.services.impl.ColourPrinterImpl;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class ColorAppApplication implements CommandLineRunner {

	private ColourPrinter colourPrinter;

	public ColorAppApplication(ColourPrinter colourPrinter) {
		this.colourPrinter = colourPrinter;
	}


	public static void main(String[] args) {
		SpringApplication.run(ColorAppApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		log.info(colourPrinter.print());
	}

}
