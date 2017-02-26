package com.training.spring.boot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.training.spring.boot.domain.User;
import com.training.spring.boot.service.AppService;
import com.training.spring.boot.service.UserLog;
import com.training.spring.boot.service.UserService;

/**
 * Hello world!
 *
 */
@Controller
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.training.spring.boot" })
@EnableWebMvc
public class App {
	@Autowired
	private AppService appService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLog userLog;

	@RequestMapping("/")
	public ModelAndView home() {
		Map<String, String> model = new HashMap<String, String>();
		model.put("author", appService.getAuthor());
		return new ModelAndView("hello", model);
	}
	
	@RequestMapping("/user")
	public String user(){
		return "user";
	}

	@RequestMapping("/list")
	public ModelAndView listUser() {
		Map<String, List<String>> model = new HashMap<String, List<String>>();
		model.put("list", userService.getList());
		return new ModelAndView("list", model);
	}
	
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute("firstName") String firstName, @ModelAttribute("lastName") String lastName, @ModelAttribute("address") String address){
		if (userService.saveUser(firstName, lastName, address)){
			return "redirect:list";
		}
		return "redirect:user";
	}
	
	@RequestMapping("/log/{firstName}/{lastName}")
	public ModelAndView viewlog(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
		Map<String, List<User>> model = new HashMap<String, List<User>>();
		model.put("list", userLog.getListLog(firstName, lastName));
		return new ModelAndView("log", model);
	}

	public static void main(String[] args) {
		SpringApplication springBootApp = new SpringApplication(App.class);
		springBootApp.run(args);
	}
}
