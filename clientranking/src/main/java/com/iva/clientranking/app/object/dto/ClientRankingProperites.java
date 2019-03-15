package com.iva.clientranking.app.object.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class ClientRankingProperites {

	@Value("${clientRanking.ranking.limit:40}")
	private Integer rankingLimit;

	@Value("${clientRanking.ranking.startDate}")
	private LocalDate filterStartDate;

}
