package com.sood1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sood1.demo.dao.AlienRepo;
import com.sood1.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}

	@RequestMapping("/al")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		mv.addObject(alien);
		return mv;
		
		
		
		/*
		 * System.out.println(repo.findByTech("JAVA"));
		 * System.out.println(repo.findByAidGreaterThan(102));
		 * System.out.println(repo.findByAidLessThan(104));
		 * System.out.println(repo.findByTechSorted("JAVA"));
		 */
		
	}
	
}
