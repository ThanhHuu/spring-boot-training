package com.training.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */
@Controller
@SpringBootConfiguration
public class App 
{
	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "Hello";
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
