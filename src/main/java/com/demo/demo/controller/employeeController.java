package com.demo.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.demo.entity.employee;
import com.demo.demo.service.empService;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class employeeController {

    private final empService empService;

    public employeeController(empService empService) {
        this.empService = empService;
    }

    @PostMapping("/checkIn")
    public employee checkIn(@RequestBody employee emp) {
        return empService.checkIn(emp);
    }

    @PostMapping("/checkOut")
    public employee checkOut(@RequestBody employee emp) {
        return empService.checkOut(emp);
    }

    @GetMapping("/findAll")
    public List<employee> findAll() {
        return empService.findAll();
    }
}
