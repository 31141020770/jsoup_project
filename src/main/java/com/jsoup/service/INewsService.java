package com.jsoup.service;

import org.json.JSONObject;

public interface INewsService {
	JSONObject findAll();
	JSONObject findByWebName(String code);
	JSONObject searchById(long id);
}
