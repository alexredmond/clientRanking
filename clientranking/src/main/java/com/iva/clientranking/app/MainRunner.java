package com.iva.clientranking.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MainRunner implements CommandLineRunner {

	@Override
	public void run(String... args) {
		log.info("EXECUTING : command line runner");

	}
	
}
