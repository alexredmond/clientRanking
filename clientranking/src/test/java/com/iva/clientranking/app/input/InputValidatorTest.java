package com.iva.clientranking.app.input;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import com.iva.clientranking.app.object.dto.ClientRankingProperites;
import com.iva.clientranking.app.object.exception.ClientRankingException;

public class InputValidatorTest {

	@InjectMocks
	private InputValidator inputValidator;

	@Mock
	private ClientRankingProperites clientRankingProperites;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(clientRankingProperites.getFilterStartDate()).thenReturn(LocalDate.now());
		when(clientRankingProperites.getRankingLimit()).thenReturn(1);
	}

	@Test(expected = ClientRankingException.class)
	public void checkLimitEmpty() throws ClientRankingException {
		when(clientRankingProperites.getRankingLimit()).thenReturn(null);
		inputValidator.validateProperties();
	}

	@Test(expected = ClientRankingException.class)
	public void checkLimitNegative() throws ClientRankingException {
		when(clientRankingProperites.getRankingLimit()).thenReturn(-1);
		inputValidator.validateProperties();
	}

	@Test
	public void checkLimitPositive() throws ClientRankingException {
		when(clientRankingProperites.getRankingLimit()).thenReturn(5);
		inputValidator.validateProperties();
	}

	@Test(expected = ClientRankingException.class)
	public void checkLimitZero() throws ClientRankingException {
		when(clientRankingProperites.getRankingLimit()).thenReturn(0);
		inputValidator.validateProperties();
	}

	@Test(expected = ClientRankingException.class)
	public void checkEmptyDate() throws ClientRankingException {
		when(clientRankingProperites.getFilterStartDate()).thenReturn(null);
		inputValidator.validateProperties();
	}

}
