package com.jsoup.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsoup.infocrawler.InfoUse;

@Controller
public class crawlerController {
	@Autowired
	private InfoUse infoUse;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() throws IOException {
		ModelAndView mav = new ModelAndView("home");
		JSONObject json = infoUse.GetUse();
		mav.addObject("json",json);
		return mav;
	}
}
