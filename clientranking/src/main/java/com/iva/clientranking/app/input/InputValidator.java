package com.iva.clientranking.app.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iva.clientranking.app.object.dto.ClientRankingProperites;
import com.iva.clientranking.app.object.exception.ClientRankingException;

@Component
public class InputValidator {

	@Autowired
	private ClientRankingProperites clientRankingProperites;

	public void validateProperties() throws ClientRankingException {
		if (clientRankingProperites.getRankingLimit() == null
				|| clientRankingProperites.getRankingLimit().compareTo(0) <= 0) {
			throw new ClientRankingException("RanlingLimit must be higher than 0");
		}
		if (clientRankingProperites.getFilterStartDate() == null) {
			throw new ClientRankingException("RanlingStartDate must be a valid Date");
		}
	}

}
