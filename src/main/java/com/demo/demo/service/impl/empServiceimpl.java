package com.demo.demo.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.employee;
import com.demo.demo.repository.employeRepo;
import com.demo.demo.service.empService;

@Service
public class empServiceimpl implements empService {

    @Autowired
    private employeRepo employeRepo;

    public empServiceimpl(employeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }


    @Override
    public employee checkIn(employee employeeInput) {
        LocalDate today = LocalDate.now();
        // ✅ Use employeeId now!
        Optional<employee> optional = employeRepo.findByEmployeeIdAndDate(employeeInput.getEmployeeId(), today);

        if (optional.isPresent()) {
            employee existing = optional.get();
            if (existing.getCheckIn() != null) {
                return existing;
            }
            existing.setCheckIn(LocalDateTime.now());
            return employeRepo.save(existing);
        } else {
            employee newEmp = new employee();
            newEmp.setEmployeeId(employeeInput.getEmployeeId());  // ✅ use employeeId, not id!
            newEmp.setDate(today);
            newEmp.setCheckIn(LocalDateTime.now());
            return employeRepo.save(newEmp);
        }
    }

    @Override
    public employee checkOut(employee employeeInput) {
        LocalDate today = LocalDate.now();
        // ✅ Use employeeId now!
        Optional<employee> optional = employeRepo.findByEmployeeIdAndDate(employeeInput.getEmployeeId(), today);

        if (optional.isPresent()) {
            employee existing = optional.get();
            existing.setCheckOut(LocalDateTime.now());
            return employeRepo.save(existing);
        } else {
            throw new RuntimeException("No check-in record found for today.");
        }
    }

    @Override
    public List<employee> findAll() {
        return employeRepo.findAll();
    }

}





 // @Override
    // public employee checkIn(employee employeeInput) {
    //     LocalDate today = LocalDate.now();
    //     Optional<employee> optional = employeRepo.findByIdAndDate(employeeInput.getId(), today);

    //     if (optional.isPresent()) {
    //         employee existing = optional.get();
    //         if (existing.getCheckIn() != null) {
    //             return existing; 
    //         }
    //         existing.setCheckIn(LocalDateTime.now());
    //         return employeRepo.save(existing);
    //     } else {
    //         employee newEmp = new employee();
    //         newEmp.setId(employeeInput.getId());
    //         newEmp.setDate(today);
    //         newEmp.setCheckIn(LocalDateTime.now());
    //         return employeRepo.save(newEmp);
    //     }
    // }

    // @Override
    // public employee checkOut(employee employeeInput) {
    //     LocalDate today = LocalDate.now();
    //     Optional<employee> optional = employeRepo.findByIdAndDate(employeeInput.getId(), today);

    //     if (optional.isPresent()) {
    //         employee existing = optional.get();

    //         // if (existing.getCheckOut() != null) {
    //         //     return existing; 
    //         // }

    //         // if (existing.getCheckIn() == null) {
    //         //     throw new RuntimeException("Cannot check out without check-in.");
    //         // }

    //         existing.setCheckOut(LocalDateTime.now());
    //         return employeRepo.save(existing);
    //     } else {
    //         throw new RuntimeException("No check-in record found for today.");
    //     }
    // }

    // @Override
    // public List<employee> findAll() {
    //     return employeRepo.findAll();
    // }