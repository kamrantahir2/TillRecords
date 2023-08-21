package com.example.TillRecords.controller;

import com.example.TillRecords.model.Till;
import com.example.TillRecords.service.TillService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return objectMapper.writeValueAsString(tillService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable int id) throws JsonProcessingException {
        Optional<Till> opt = tillService.findById(id);
        if (opt.isPresent()) {
            Till till = opt.get();
            return new ResponseEntity<>(objectMapper.writeValueAsString(till), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Till not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTill(@RequestBody Till till) throws JsonProcessingException {
        Optional<Till> opt = Optional.of(till);
        if (opt.isPresent()) {
            Till gotTill = opt.get();
            gotTill.setDateTime();
            tillService.save(gotTill);
            String json = objectMapper.writeValueAsString(till);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Till", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTill(@PathVariable int id) throws JsonProcessingException {
        Optional<Till> opt = tillService.findById(id);
        if (opt.isPresent()) {
            Till till = opt.get();
            tillService.delete(till);
            return new ResponseEntity<>(objectMapper.writeValueAsString(tillService.findAll()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Till not found", HttpStatus.NOT_FOUND);
        }
    }

}