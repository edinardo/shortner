package com.sibilante.shortner.service;

public interface ShortnerService {

	public String urlShorter(String url);
	
	public String getOriginalLink(String shortnedUrl);
	
}
