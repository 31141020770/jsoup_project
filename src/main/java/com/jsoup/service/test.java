package com.jsoup.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public static void main (String[] args) throws IOException {
		
		String URL = "https://www.vnexpress.net";
		// 2. Fetch the HTML code
		/* Document document = Jsoup.parse(new URL(URL).openStream(), "UTF-8", URL); */
		Document document;
		try {
			document = Jsoup.connect(URL).get();
			// 3. Parse the HTML to extract links to other URLs
			Elements linksOnPage = document.select("h3.title-news>a, h3.title_news>a");
			JSONObject sampleObject = new JSONObject();

			for (int i = 0; i < linksOnPage.size(); i++) {
				JSONArray arr = new JSONArray();
				Element link = linksOnPage.get(i);

				String url = link.attr("abs:href");
				/* String title = link.attr("title"); */
				arr.put(url);
				/* arr.put(title); */
				/*
				 * Document doc = Jsoup.connect(url).get(); Elements time =
				 * doc.select("div.mb15 >span.time-update"); Elements des =
				 * doc.select("div.edittor-content > p"); arr.put(des.text());
				 * arr.put(time.text());
				 */
				sampleObject.put(Integer.toString(i), arr);
			}
			System.out.println(sampleObject);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
