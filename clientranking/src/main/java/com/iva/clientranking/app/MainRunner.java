package com.iva.clientranking.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iva.clientranking.app.input.InputProcessor;
import com.iva.clientranking.app.object.dto.InputDto;
import com.iva.clientranking.app.service.LogicSevice;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MainRunner implements CommandLineRunner {

	private InputProcessor inputProcessor;
	private LogicSevice logicService;
	

	@Autowired
	public MainRunner(InputProcessor inputProcessor, LogicSevice logicService) {
		super();
		this.inputProcessor = inputProcessor;
		this.logicService = logicService;
	}



	@Override
	public void run(String... args) {
		log.info("EXECUTING : command line runner");

		InputDto inputDto = inputProcessor.process(args);
		if (inputDto != null) {
			logicService.runRanking(inputDto);
		}

	}

}
