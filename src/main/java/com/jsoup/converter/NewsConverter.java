package com.jsoup.converter;

import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.jsoup.entity.NewsEntity;

@Component
public class NewsConverter {
	public JSONArray toJsonObject(NewsEntity news) {
		JSONArray arr = new JSONArray();
		arr.put(news.getUrl());
		arr.put(news.getTitle());
		arr.put(news.getPostTime());
		arr.put(news.getContent());
		return arr;
	}
}