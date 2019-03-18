package com.iva.clientranking.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iva.clientranking.app.input.InputProcessor;
import com.iva.clientranking.app.object.dto.InputDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogicSeviceIT {
	
	@Autowired
	private InputProcessor inputProcessor;
	@Autowired
	private LogicSevice logicService;

	@Test
	public void testClientFilter() {

		InputDto inputDto = inputProcessor.process("files/test1/c5.csv", "files/test1/a5.csv", "files/test1/s5.csv",
				"files/test1/p5.csv");
		logicService.runRanking(inputDto);

	}
}
