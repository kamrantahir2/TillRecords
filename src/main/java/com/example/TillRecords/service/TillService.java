package com.example.TillRecords.service;

import com.example.TillRecords.model.Till;
import com.example.TillRecords.repository.TillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TillService {

    @Autowired
    private TillRepository tillRepository;

    public TillRepository getTillRepository() {
        return tillRepository;
    }

    public void setTillRepository(TillRepository tillRepository) {
        this.tillRepository = tillRepository;
    }

    public TillService() {
    }

    public Till save(Till till) {
        tillRepository.save(till);
        return till;
    }

    public Iterable<Till> findAll() {
        return tillRepository.findAll();
    }

    public Optional<Till> findById(int id) {
        return tillRepository.findById(id);
    }

    public Till delete(Till till) {
        tillRepository.delete(till);
        return till;
    }

    public Iterable<Till> findByOverUnderLessThan(double lessThan) {
        return tillRepository.findByOverUnderLessThan(lessThan);
    }



}