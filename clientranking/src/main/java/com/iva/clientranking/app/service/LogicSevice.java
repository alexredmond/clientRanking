package com.iva.clientranking.app.service;

import org.springframework.stereotype.Service;

import com.iva.clientranking.app.object.dto.InputDto;

@Service
public class LogicSevice {

	public void runRanking(InputDto inputDto) {
		
		inputDto.getClientList().stream()
			.filter(c -> !c.isBanned())
			.forEach(System.out::print);
		
	}
	
	

}
