package com.iva.clientranking.app.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iva.clientranking.app.object.dto.ClientRankingProperites;
import com.iva.clientranking.app.object.dto.InputDto;

@Component
public class AppointmentFilter {

	private ClientRankingProperites clientRankingProperites;

	@Autowired
	public AppointmentFilter(ClientRankingProperites clientRankingProperites) {
		super();
		this.clientRankingProperites = clientRankingProperites;
	}

	public void collectValidAppointemntsPoints(InputDto inputDto) {
		
		ZonedDateTime fiterStart = clientRankingProperites.getZonedFilterDateTime();
		
		inputDto.getAppointmentList().stream()
		.filter(a -> (a.getStartTime().isAfter( fiterStart) || a.getStartTime().isEqual(fiterStart)))
		.forEach(System.out::println);
		
	}

}
