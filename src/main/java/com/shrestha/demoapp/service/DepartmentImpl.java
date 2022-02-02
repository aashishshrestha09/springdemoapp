package com.shrestha.demoapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.shrestha.demoapp.entity.Department;
import com.shrestha.demoapp.error.DepartmentNotFoundException;
import com.shrestha.demoapp.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        // TODO Auto-generated method stub
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        // TODO Auto-generated method stub
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        // TODO Auto-generated method stub
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        // TODO Auto-generated method stub
        departmentRepository.deleteById(departmentId);   
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        // TODO Auto-generated method stub
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && 
        !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && 
        !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
        !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        // TODO Auto-generated method stub
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
    
}
