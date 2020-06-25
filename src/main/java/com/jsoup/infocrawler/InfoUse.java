package com.jsoup.infocrawler;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class InfoUse {
	private String displayAll;
	private String displayByCode;
	private String searchById;
	public JSONObject GetUse() {
		InfoUse infoUse = new InfoUse();
		JSONObject json = new JSONObject();
		infoUse.setDisplayAll("/api/all" + " display all URL, time, title, content of news of vnexpress and vtc already can crawler ");
		infoUse.setDisplayByCode("/api/namecode" + " namecode= vnexpress or vtc");
		infoUse.setSearchById("/api/search/id" );
		json.put("display all",infoUse.getDisplayAll());
		json.put("filter on code web",infoUse.getDisplayByCode());
		json.put("search by id", infoUse.getSearchById());
		return json;
		
	}
	public String getDisplayAll() {
		return displayAll;
	}
	public void setDisplayAll(String displayAll) {
		this.displayAll = displayAll;
	}
	public String getDisplayByCode() {
		return displayByCode;
	}
	public void setDisplayByCode(String displayByCode) {
		this.displayByCode = displayByCode;
	}
	public String getSearchById() {
		return searchById;
	}
	public void setSearchById(String searchById) {
		this.searchById = searchById;
	}
	
}
