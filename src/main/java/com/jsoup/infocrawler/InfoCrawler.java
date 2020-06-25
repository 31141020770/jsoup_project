package com.jsoup.infocrawler;

import org.springframework.stereotype.Component;

@Component
public class InfoCrawler {
	String URL;
	String LinkPage;
	String Time;
	String content;
	String code;

	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getLinkPage() {
		return LinkPage;
	}
	public void setLinkPage(String linkPage) {
		LinkPage = linkPage;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public InfoCrawler VnExpress() {
		InfoCrawler infoCrawler = new InfoCrawler();
		infoCrawler.setURL("https://www.vnexpress.net");
		infoCrawler.setLinkPage("h3.title-news>a,h3.title_news>a");
		infoCrawler.setTime("div.header-content> span.date,p.meta>span.time");
		infoCrawler.setContent("p.description, p.Normal");
		infoCrawler.setCode("vnexpress");
		return infoCrawler;
	}
	public InfoCrawler VTC() {
		InfoCrawler infoCrawler = new InfoCrawler();
		infoCrawler.setURL("https://vtc.vn");
		infoCrawler.setLinkPage("h2.font15>a, h2.font24>a, h2.font13>a, h3.font15>a, h3.font16>a");
		infoCrawler.setTime("div.mb15 >span.time-update");
		infoCrawler.setContent("div.edittor-content > p");
		infoCrawler.setCode("vtc");
		return infoCrawler;
	}
}
