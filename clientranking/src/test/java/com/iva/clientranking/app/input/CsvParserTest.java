package com.iva.clientranking.app.input;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iva.clientranking.app.object.dto.InputDto;

public class CsvParserTest {
	
	@InjectMocks
	private CsvParser csvParser; 
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testParsingFile() {
		InputDto inputDto = new InputDto();
		
	            inputDto.setClientFilePath(Paths.get("files/test1/c1.csv"));

	            csvParser.parseInputParameters( inputDto);
	}

}
