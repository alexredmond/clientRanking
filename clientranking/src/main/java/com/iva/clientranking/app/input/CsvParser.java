package com.iva.clientranking.app.input;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iva.clientranking.app.object.dto.InputDto;
import com.iva.clientranking.app.object.entity.Client;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;

@Component
public class CsvParser {

	public void parseInputParameters(InputDto inputDto) {
		try {
			inputDto.setClientList(beanBuilderExample(inputDto.getClientFilePath(), Client.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public <T> List<T> beanBuilderExample(Path path, Class<T> clazz) throws Exception {
		MappingStrategy<T> ms = new HeaderColumnNameMappingStrategy<T>();
		ms.setType(clazz);

		try (Reader reader2 = Files.newBufferedReader(path)) {
			CsvToBean<T> cb2 = new CsvToBeanBuilder<T>(reader2).withType(clazz).withMappingStrategy(ms).build();
			return cb2.parse();
		}
	}
	
}
