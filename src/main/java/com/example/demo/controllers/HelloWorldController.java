package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("adder")
	public String adder() {
		return "helloworld/adder-form";
	}
	
	@GetMapping("subtracter")
	public String subtracter() {
		return "helloworld/subtracter-form";
	}
		
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", message);
		return mv;
	}
	
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«silence»") String whisper) {
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		mv.addObject("title", title.toLowerCase());
		mv.addObject("whisper", whisper);
		return mv;
	}
	
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		model.addAttribute("sum", first + second);
		return "helloworld/sum-result";
	}
	
	@PostMapping("subtracter")
	public String subtractTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		model.addAttribute("difference", first - second);
		return "helloworld/subtract-result";
	}
	
	
}
