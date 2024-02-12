package com.mizu.pocopenai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mizu.pocopenai.services.OpenAiService;

@RestController
public class OpenAiController {
	
	private final OpenAiService service;
	
	@Autowired
	public OpenAiController(OpenAiService service) {
		this.service = service;
	}

	@GetMapping("/travel-reasons")
    public ResponseEntity<String> jobReasons(@RequestParam(value = "count", required = false, defaultValue = "3") int count,
                                             @RequestParam("location") String location) {
        return new ResponseEntity<>(service.getTravelReasons(count, location), HttpStatus.OK);
    }
}	