package com.example.demo.service;

import com.example.demo.dto.employeeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    employeeDTO save(employeeDTO emDTO);
    void delete(long[] idEmployee);
    void delete(long idEmployee);
    employeeDTO getById(long idEm);
    List<employeeDTO> findAll();
    List<employeeDTO> findAll(Pageable pageable);
    int totalItem();
}
