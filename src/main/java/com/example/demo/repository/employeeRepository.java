package com.example.demo.repository;

import com.example.demo.entity.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface employeeRepository extends JpaRepository<employeeEntity,Long> {

}
