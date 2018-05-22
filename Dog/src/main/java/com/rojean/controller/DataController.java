package com.rojean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cache")
public class DataController {

	@RequestMapping("toCacheQuery")
	public ModelAndView toCacheQuery() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/cache/cacheQuery");
		return model;
	}
}
