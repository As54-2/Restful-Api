package com.example.demo.repo;

import com.example.demo.com.Model;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeRepo extends JpaRepository<Model,Long> {

void deleteEmployeeById(Long id);

Optional <Model> findEmployeeById(Long id);

}
