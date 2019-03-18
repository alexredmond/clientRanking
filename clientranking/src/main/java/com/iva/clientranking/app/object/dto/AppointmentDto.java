package com.iva.clientranking.app.object.dto;

import lombok.Data;

@Data
public class AppointmentDto {

	private String appointmentId;
	private String clientId;

	private Integer servicePoints = 0;
	private Integer purchasePoints = 0;

}
