package com.javaprojects.javaspring.service;

import com.javaprojects.javaspring.entity.Department;
import com.javaprojects.javaspring.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getListAllDeparments();

    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentID);

    Department updateDepartment(Long departmentID, Department department) throws DepartmentNotFoundException;

    Department fetchDepartmentByName(String departmentName);

    Department fetchDepartmentByNameIgonoreCase(String departmentName);
}
