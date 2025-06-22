package com.demo.demo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.demo.entity.employee;



public interface employeRepo extends MongoRepository<employee,String>{

    Optional<employee> findByIdAndDate(String id, LocalDate date);

}
