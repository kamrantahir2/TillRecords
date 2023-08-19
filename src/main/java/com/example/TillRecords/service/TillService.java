package com.example.TillRecords.service;

import com.example.TillRecords.model.Till;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TillService {

//    This service class will use a hardcoded array as temporary storage

    private List<Till> db = new ArrayList<>();

    public List<Till> getDb() {
        return db;
    }

    public void setDb(List<Till> db) {
        this.db = db;
    }

    public TillService(List<Till> db) {
        this.db = db;
    }

    public TillService() {
    }

    public Till save(Till till) {
        db.add(till);
        return till;
    }

}