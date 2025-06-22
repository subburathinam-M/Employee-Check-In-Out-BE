package com.demo.demo.service;

import java.util.List;

import com.demo.demo.entity.employee;

public interface empService {

    employee checkIn(employee employee);
    employee checkOut(employee employee);
    List<employee> findAll();

}
