package com.jsoup.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jsoup.infocrawler.InfoCrawler;
@Service
public class CheduledUpdate {
	@Autowired
	WebCrawler webCrawler;
	@Autowired
	InfoCrawler infoCrawler;
	public static final int timeCrawler = 100000;	
	@Scheduled(fixedRate = timeCrawler)
	public void work() throws IOException {
		System.out.println("update");
		webCrawler.getPageLinks(infoCrawler.VnExpress());
		System.out.println("update 1");
		webCrawler.getPageLinks(infoCrawler.VTC());
		System.out.println("update 2");
	}
}

