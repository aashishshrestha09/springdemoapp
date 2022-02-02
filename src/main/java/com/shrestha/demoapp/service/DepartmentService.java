package com.shrestha.demoapp.service;

import java.util.List;

import com.shrestha.demoapp.entity.Department;
import com.shrestha.demoapp.error.DepartmentNotFoundException;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
    
}
