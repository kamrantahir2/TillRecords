package com.example.TillRecords.controller;

import com.example.TillRecords.model.Till;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/")
    public String home() throws JsonProcessingException {
        Till till = new Till("1", 2, 3, 4);

        return objectMapper.writeValueAsString(till);
    }

}