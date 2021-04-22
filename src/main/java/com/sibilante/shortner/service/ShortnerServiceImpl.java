package com.sibilante.shortner.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class ShortnerServiceImpl implements ShortnerService {

	private Map<String, String> table = new HashMap<>();

	@Override
	public String urlShorter(String url) {
		String shortenedUrl = randomValue(url);
		// Should check if the URL already exists, but will have the same cost as the
		// MAP will no allow duplicates.
		table.put(shortenedUrl, url);
		return shortenedUrl;
	}

	@Override
	public String getOriginalLink(String shortnedUrl) {
		return table.get(shortnedUrl);
	}

	// Need to chose a better algorithm to deal with hash collision
	private String randomValue(String url) {
		return Hashing.crc32().hashString(url, StandardCharsets.UTF_8).toString();
	}

}
