package com.javaprojects.javaspring.service;

import com.javaprojects.javaspring.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getListAllDeparments();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentID);

    Department updateDepartment(Long departmentID, Department department);
}
