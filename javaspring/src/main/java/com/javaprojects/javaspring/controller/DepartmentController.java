package com.javaprojects.javaspring.controller;

import com.javaprojects.javaspring.entity.Department;
import com.javaprojects.javaspring.error.DepartmentNotFoundException;
import com.javaprojects.javaspring.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        logger.info("Inside the saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getListAllDeparments(){
        logger.info("Inside the getListAllDeparments");
        return departmentService.getListAllDeparments();
    }

    @GetMapping("/departments/{id}")
    public Department getListAllDeparmentById(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentID){
        departmentService.deleteDepartmentById(departmentID);
        return "department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID,@RequestBody Department department) throws DepartmentNotFoundException {

        return departmentService.updateDepartment(departmentID, department);
    }

    @GetMapping("/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/name/ignorecase/{name}")
    public Department fetchDepartmentByNameIgnoreCase(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByNameIgonoreCase(departmentName);
    }
}
