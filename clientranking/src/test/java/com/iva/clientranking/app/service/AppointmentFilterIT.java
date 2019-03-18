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
public class AppointmentFilterIT {
	
	@Autowired
	private InputProcessor inputProcessor;
	@Autowired
	private AppointmentFilter appointmentFilter;

	@Test
	public void testClientFilter() {

		InputDto inputDto = inputProcessor.process("files/test1/5c.csv", "files/test1/5a.csv", "files/test1/5s.csv",
				"files/test1/5p.csv");
		appointmentFilter.collectValidAppointemntsPoints(inputDto);

	}
}
