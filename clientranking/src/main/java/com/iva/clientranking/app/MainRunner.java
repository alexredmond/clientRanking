package com.iva.clientranking.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iva.clientranking.app.input.InputParser;
import com.iva.clientranking.app.input.InputProcessor;
import com.iva.clientranking.app.object.exception.ClientRankingException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MainRunner implements CommandLineRunner {

	@Autowired
	private InputProcessor inputProcessor;

	@Override
	public void run(String... args) {
		log.info("EXECUTING : command line runner");
	//	try {
			inputProcessor.process(args);
			
			
			
//		}catch (ClientRankingException e) {
//			log.error(e.getMessage());
//		}

	}

}
