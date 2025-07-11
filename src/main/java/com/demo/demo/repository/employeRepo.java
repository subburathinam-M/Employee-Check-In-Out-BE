package com.demo.demo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.demo.entity.employee;

import org.springframework.data.domain.Pageable;

public interface employeRepo extends MongoRepository<employee,String>{

    // Optional<employee> findByIdAndDate(String id, LocalDate date);
    Optional<employee> findByEmployeeIdAndDate(String employeeId, LocalDate date);
Page<employee> findByEmployeeIdContainingIgnoreCase(String employeeId, Pageable pageable);

}
