package com.demo.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.demo.entity.employee;
import com.demo.demo.response.PaginatedResponse;

public interface empService {

    employee checkIn(employee employee);
    employee checkOut(employee employee);
    // List<employee> findAll();
    // Page<employee> findAll(int page, int size, String sortField, String sortDir, String searchTerm);
    PaginatedResponse<employee> findAll(
        int page,
        int size,
        String sortField,
        String sortDir,
        String searchTerm
    );

    void deleteById(String id);


}
