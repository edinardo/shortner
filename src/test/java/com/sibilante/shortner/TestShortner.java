package com.sibilante.shortner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sibilante.shortner.service.ShortnerService;
import com.sibilante.shortner.service.ShortnerServiceImpl;

class TestShortner {

	private static final String HASH = "15cede7d";
	private static final String URL = "https://meet.google.com/wpg-smdo-czn?authuser=0";

	@Test
	void testShort() {
		ShortnerService shortner = new ShortnerServiceImpl();

		String result = shortner.urlShorter(URL);

		assertEquals(HASH, result);
		assertEquals(URL, shortner.getOriginalLink(HASH));
	}

}
