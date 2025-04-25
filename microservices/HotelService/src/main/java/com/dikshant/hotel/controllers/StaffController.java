package com.dikshant.hotel.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @GetMapping("/staffs")
    public ResponseEntity<List<String>> getAllStaff() {
        List<String> staffList=List.of("John Doe", "Jane Smith", "Alice Johnson");
        return ResponseEntity.ok(staffList);
    }
}
