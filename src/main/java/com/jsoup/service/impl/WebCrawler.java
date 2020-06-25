package com.jsoup.service.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoup.entity.NewsEntity;
import com.jsoup.entity.WebNameEntity;
import com.jsoup.infocrawler.InfoCrawler;
import com.jsoup.repository.NewsRepository;
import com.jsoup.repository.WebNameRepository;

@Service
public class WebCrawler {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private WebNameRepository webNameRepository;
	@Transactional
	public void getPageLinks(InfoCrawler info) throws IOException {
		Document document = Jsoup.connect(info.getURL()).get();
		Elements linksOnPage = document.select(info.getLinkPage());
		for (int i = 0; i < linksOnPage.size(); i++) {
			Element link = linksOnPage.get(i);
			String url = link.attr("abs:href");
			if (newsRepository.existsByUrl(url) == true) {
				continue;
			}
			String title = link.attr("title");
			Document doc = Jsoup.connect(url).get();
			Elements postTime = doc.select(info.getTime());
			Elements content = doc.select(info.getContent());
			NewsEntity news = new NewsEntity();
			WebNameEntity webname = webNameRepository.findOneByCode(info.getCode());
			news.setWebname(webname);
			news.setPostTime(postTime.text());
			news.setUrl(url);
			news.setTitle(title);
			news.setContent(content.text());
			newsRepository.save(news);
		}
	}
}
