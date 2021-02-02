package com.example.demo.converter;

import com.example.demo.dto.employeeDTO;
import com.example.demo.entity.employeeEntity;
import org.springframework.stereotype.Component;

@Component
public class employeeConverter {

    public employeeEntity toEntity(employeeDTO dto)
    {
        employeeEntity entity= new employeeEntity();
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    public employeeDTO toDTO(employeeEntity employEntity){
        employeeDTO dto = new employeeDTO();
        if(employEntity.getId()!=null)
        {
            dto.setId((employEntity.getId()));
        }
        dto.setFirstName(employEntity.getFirstName());
        dto.setLastName(employEntity.getLastName());
        dto.setEmail(employEntity.getEmail());
        dto.setCreatedAt(employEntity.getCreatedAt());
        dto.setUpdateAt(employEntity.getUpdateAt());
        return dto;
    }
    public employeeEntity toEntity(employeeDTO dto,employeeEntity entity)
    {
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
