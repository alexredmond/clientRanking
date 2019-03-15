package com.iva.clientranking.app.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iva.clientranking.app.object.dto.InputDto;
import com.iva.clientranking.app.object.exception.ClientRankingException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InputProcessor {
	
	@Autowired
	private InputValidator inputValidator;

	public InputDto process(String... args) {
		InputDto inputDto =  inputValidator.verifyFilesPresent(args);
		if (inputDto == null) {
			printUsage();
			return null;
		}
		try {
			inputValidator.validateProperties();


			return inputDto;
		} catch (ClientRankingException e) {
			log.error("Problem processinginpur: {}",e.getMessage());
		}
		return null;
	}

	private void printUsage() {
		log.info("Input parameters: client.csv, appointment.csv, service.csv, purchase.csv");
	}

}
