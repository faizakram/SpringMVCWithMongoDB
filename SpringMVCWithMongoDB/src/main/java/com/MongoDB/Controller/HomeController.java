package com.MongoDB.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MongoDB.Service.Homeservice;


@Controller
public class HomeController {
	
	@Autowired
	private Homeservice homeService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myList",homeService.findall());
		return "home";
	}
	
	@RequestMapping(value = "AddData", method = RequestMethod.GET)
	public String addData() {
		logger.info("Addding VAlue {}.");
		return "AddPage";
	}
	
	@RequestMapping(value = "dataAdding", method = RequestMethod.POST)
	public String addData(@RequestParam("name") String name,@RequestParam("age") Integer age, Model model) {
		logger.info("Addding VAlue {}.");
		System.out.println("name :- "+ name + "Age : - " +age);
		homeService.add(name, age);
		model.addAttribute("myList",homeService.findall());
		return "home";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("name") String name, Model model) {
		homeService.delete(name);
		model.addAttribute("myList",homeService.findall());
		return "home";
	}
	@RequestMapping(value = "findData", method = RequestMethod.GET)
	public String find(@RequestParam("name") String name, Model model) {
		model.addAttribute("Signle",homeService.find(name));
		return "home";
	}
}
