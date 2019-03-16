package com.iva.clientranking.app.object.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;

@Data
public class Client extends CsvBean {

	 @CsvBindByName(column = "id")
//	@CsvBindByPosition(position = 0)
	private String id;
	@CsvBindByName(column = "first_name")
//	@CsvBindByPosition(position = 1)
	private String firstName;
	@CsvBindByName(column = "last_name")
//	@CsvBindByPosition(position = 2)
	private String lastName;
	@CsvBindByName(column = "email")
//	@CsvBindByPosition(position = 3)
	private String email;
	@CsvBindByName(column = "phone")
//	@CsvBindByPosition(position = 4)
	private String phone;
	@CsvBindByName(column = "gender")
//	@CsvBindByPosition(position = 5)
	private String gender;
	@CsvBindByName(column = "banned")
//	@CsvBindByPosition(position = 6)
	private String banned;

}
