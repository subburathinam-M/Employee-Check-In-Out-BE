package com.demo.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.demo.demo.entity.employee;
import com.demo.demo.response.PaginatedResponse;
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

    // @GetMapping("/findAll")
    // public List<employee> findAll() {
    //     return empService.findAll();
    // }

//     @GetMapping("/findAll")
// public Page<employee> findAll(
//         @RequestParam(defaultValue = "0") int page,
//         @RequestParam(defaultValue = "5") int size,
//         @RequestParam(defaultValue = "date") String sortField,
//         @RequestParam(defaultValue = "desc") String sortDir,
//         @RequestParam(defaultValue = "") String searchTerm) {
//     return empService.findAll(page, size, sortField, sortDir, searchTerm);
// }

@GetMapping("/findAll")
public PaginatedResponse<employee> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "date") String sortField,
        @RequestParam(defaultValue = "desc") String sortDir,
        @RequestParam(defaultValue = "") String searchTerm) {
    
    return empService.findAll(page, size, sortField, sortDir, searchTerm);
}


    @DeleteMapping("/delete/{id}")
public void deleteById(@PathVariable String id) {
    empService.deleteById(id);
}

}
