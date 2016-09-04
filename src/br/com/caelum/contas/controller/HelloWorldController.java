package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/HelloWorldSpring")
	public String execute(){
		System.out.println("Running some logic with Spring MVC");
		
		return "ok";
	}
}
