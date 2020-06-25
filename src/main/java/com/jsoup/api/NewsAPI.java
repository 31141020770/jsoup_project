package com.jsoup.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsoup.service.INewsService;

@Controller
public class NewsAPI {
	@Autowired
	private INewsService newsService;

	@RequestMapping(value = "/api/{name}" , method = RequestMethod.GET)
	public ModelAndView getNewsInJson(@PathVariable String name) {
		ModelAndView mav = new ModelAndView("home");
		JSONObject json = newsService.findByWebName(name);
		mav.addObject("json", json);
		return mav;
	}
	@RequestMapping(value = "/api/all" , method = RequestMethod.GET)
	public ModelAndView getAllNewsInJson() {
	ModelAndView mav = new ModelAndView("home");
	JSONObject json = newsService.findAll();
	mav.addObject("json", json);
	return mav;
	}
	@RequestMapping(value = "/api/search/{id}", method = RequestMethod.GET)
	public ModelAndView searchByTime(@PathVariable long id) {
		ModelAndView mav = new ModelAndView("home");
		JSONObject json = newsService.searchById(id);
		mav.addObject("json", json);
		return mav;
	}
}
