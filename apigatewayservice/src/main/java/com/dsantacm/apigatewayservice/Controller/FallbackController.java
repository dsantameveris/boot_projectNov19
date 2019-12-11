package com.dsantacm.apigatewayservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
	
    @GetMapping("/message")
    
	public String TestMessage() {
		return "Test Message";
	}

}