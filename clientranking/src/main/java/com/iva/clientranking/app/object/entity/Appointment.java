package com.iva.clientranking.app.object.entity;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Appointment extends CsvBean {

	@CsvBindByName(column = "id")
	private String id;
	@CsvBindByName(column = "client_id")
	private String clientId;
	
	
	@CsvCustomBindByName(column = 'start_time', converter = Bar.class)
	@CsvBindByName(column = "start_time")
	@CsvDate("yyyy-MM-dd HH:mm:ss Z")
	private LocalDate startTime;
	@CsvBindByName(column = "end_time")
	private String endTime;

}
