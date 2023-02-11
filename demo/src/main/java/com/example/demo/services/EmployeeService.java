package com.example.demo.services;
import com.example.demo.com.Model;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService

{

    private  final EmployeeRepo employeeRepo;

@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Model addEmployee (Model employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.saveAndFlush(employee);

}

public List<Model> findAllEmployees(){
    return employeeRepo.findAll();
}
public Model updateEmployee(Model employee){
    return employeeRepo.saveAndFlush(employee);
}

public void deleteEmployee(Long id){
    employeeRepo.deleteEmployeeById(id);
}

public Model findEmployeeById(Long id){

    return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("user with this id "+id+"was not found"));
}
}