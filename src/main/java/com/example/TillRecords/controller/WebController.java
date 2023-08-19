package com.example.TillRecords.controller;

import com.example.TillRecords.model.Till;
import com.example.TillRecords.service.TillService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WebController {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TillService tillService;

    public WebController(TillService tillService) {
        this.tillService = tillService;
    }

    public WebController() {
    }

    public TillService getTillService() {
        return tillService;
    }

    public void setTillService(TillService tillService) {
        this.tillService = tillService;
    }

    @GetMapping("/")
    public String home() throws JsonProcessingException {
        return objectMapper.writeValueAsString(tillService.getDb());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTill(@RequestBody Till till) throws JsonProcessingException {
        Optional opt = Optional.of(till);
        if (opt.isPresent()) {
            tillService.save(till);
            String json = objectMapper.writeValueAsString(till);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Till", HttpStatus.BAD_REQUEST);
        }
    }

}