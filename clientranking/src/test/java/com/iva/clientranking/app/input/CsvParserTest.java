package com.iva.clientranking.app.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iva.clientranking.app.object.dto.InputDto;
import com.iva.clientranking.app.object.entity.Client;

public class CsvParserTest {

	@InjectMocks
	private CsvParser csvParser;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testParsingClientFile() {
		InputDto inputDto = new InputDto();
		inputDto.setClientFilePath(Paths.get("files/test1/c1.csv"));
		csvParser.parseInputParameters(inputDto);
		assertNotNull(inputDto.getClientList());
	}

	@Test(expected = NoSuchFileException.class)
	public void testParserNoFile() throws Exception {
		csvParser.beanBuilderExample(Paths.get("files/test1/c1-test.csv"), Client.class);
		fail("Should be here");
	}

	@Test
	public void testParserNull() throws Exception {
		List<Client> result = csvParser.beanBuilderExample(null, Client.class);
		assertNull(result);
	}

	@Test
	public void testParser100() throws Exception {
		List<Client> result = csvParser.beanBuilderExample(Paths.get("files/test1/c1.csv"), Client.class);
		assertEquals(100, result.size());
		Client client1 = result.get(0);
		assertEquals("e0b8ebfc-6e57-4661-9546-328c644a3764", client1.getId());
		assertEquals("Dori", client1.getFirstName());
		assertEquals("Dietrich", client1.getLastName());
		assertEquals("patrica@keeling.net", client1.getEmail());
		assertEquals("(272) 301-6356", client1.getPhone());
		assertEquals("Male", client1.getGender());
		assertFalse(client1.isBanned());
		Client client100 = result.get(99);
		assertEquals("1163f823-3849-4294-8a7c-66a556f5122c", client100.getId());
		assertEquals("Hugo", client100.getFirstName());
		assertEquals("MacGyver", client100.getLastName());
		assertEquals("jason@wehnermarks.co", client100.getEmail());
		assertEquals("(875) 159-3581", client100.getPhone());
		assertEquals("Male", client100.getGender());
		assertFalse(client100.isBanned());
	}

	@Test(expected = RuntimeException.class)
	public void testParserC3() throws Exception {
		csvParser.beanBuilderExample(Paths.get("files/test1/c3.csv"), Client.class);
		fail("Should be here");
	}

	@Test
	public void testParsingFile() {
		InputDto inputDto = new InputDto();
		inputDto.setAppointmentFilePath(Paths.get("files/test1/a1.csv"));
		csvParser.parseInputParameters(inputDto);
		assertNotNull(inputDto.getAppointmentList());
	}
}
