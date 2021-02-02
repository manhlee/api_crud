package com.example.demo.service;

import com.example.demo.converter.employeeConverter;
import com.example.demo.dto.employeeDTO;
import com.example.demo.entity.employeeEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class employeeService implements IEmployeeService{

    @Autowired
    private employeeRepository employRes;

    @Autowired
    private employeeConverter employConverter;

    @Override
    public employeeDTO save(employeeDTO emDTO) {
        employeeEntity employEntity=new employeeEntity();
        if(emDTO.getId()!=null)
        {
            employeeEntity oldNewEntity = employRes.getOne(emDTO.getId());
            employEntity =employConverter.toEntity(emDTO,oldNewEntity);
        }else {
            employEntity=employConverter.toEntity(emDTO);
        }
        employEntity=employRes.save(employEntity);
        return employConverter.toDTO(employEntity);
    }

    @Override
    public void delete(long[] idEmployee){
        for(long item: idEmployee){
            try {
                employRes.deleteById(item);
            }catch(Exception ex){
                throw new NotFoundException("Employee Id "+item+" not found");
            }
        }
    }

    @Override
    public List<employeeDTO> findAll() {
        List<employeeDTO> results = new ArrayList<>();
        List<employeeEntity> entities = employRes.findAll();
        for (employeeEntity item: entities) {
            employeeDTO newDTO = employConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public List<employeeDTO> findAll(Pageable pageable) {
        List<employeeDTO> results = new ArrayList<>();
        List<employeeEntity> entities = employRes.findAll(pageable).getContent();
        for (employeeEntity item: entities) {
            employeeDTO newDTO = employConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }
    @Override
    public void delete(long idEmployee)
    {

        try {
            employRes.deleteById(idEmployee);
        }catch(Exception ex){
            throw new NotFoundException("Employee Id "+idEmployee+" not found");
        }
    }

    @Override
    public int totalItem() {
        return (int) employRes.count();
    }
    @Override
    public employeeDTO getById(long idEm){
        try {
            employeeEntity employEntity=new employeeEntity();
            employEntity=employRes.getOne(idEm);
            return employConverter.toDTO(employEntity);

        }catch(Exception ex){
            throw new NotFoundException("Employee Id "+idEm+" not found");
        }
    };
}
