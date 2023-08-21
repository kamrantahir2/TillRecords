package com.example.TillRecords.repository;

import com.example.TillRecords.model.Till;
import org.springframework.data.repository.CrudRepository;

public interface TillRepository extends CrudRepository<Till, Integer> {
}
