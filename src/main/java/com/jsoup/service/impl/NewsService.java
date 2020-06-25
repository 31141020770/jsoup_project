package com.jsoup.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoup.converter.NewsConverter;
import com.jsoup.entity.NewsEntity;
import com.jsoup.repository.NewsRepository;
import com.jsoup.service.INewsService;

@Service
public class NewsService implements INewsService {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private NewsConverter newsConverter;

	@Override
	public JSONObject findAll() {
		List<NewsEntity> newsEntity = newsRepository.findAll();
		JSONObject jsonObject = new JSONObject();
		for (NewsEntity news : newsEntity) {
			jsonObject.put(news.getId().toString(), newsConverter.toJsonObject(news));
		}
		return jsonObject;
	}

	@Override
	public JSONObject findByWebName(String code) {
		List<NewsEntity> newsEntity = newsRepository.findByWebnameCode(code);
		JSONObject jsonObject = new JSONObject();
		for (NewsEntity news : newsEntity) {
			jsonObject.put(news.getId().toString(), newsConverter.toJsonObject(news));
		}
		return jsonObject;
	}

	@Override
	public JSONObject searchById(long id) {
		List<NewsEntity> newsEntity = newsRepository.findById(id);
		JSONObject jsonObject = new JSONObject();
		for (NewsEntity news : newsEntity) {
			jsonObject.put(news.getId().toString(), newsConverter.toJsonObject(news));
		}
		return jsonObject;
	}

}
