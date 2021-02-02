package com.example.demo.serviceTest;

import com.example.demo.converter.employeeConverter;
import com.example.demo.dto.employeeDTO;
import com.example.demo.repository.employeeRepository;
import com.example.demo.service.employeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class employeeServiceTest {
    @MockBean
    private employeeRepository employRes;
    @MockBean
    private employeeConverter employConverter;
    @InjectMocks
    private employeeService employService;

    @Test
    public void saveNewEmployeeTest(){
        employeeDTO emDTO= new employeeDTO("Le Sy","Duc","manhdzzd@gmail.com");
        Mockito.when(employService.save(emDTO)).thenReturn(emDTO);
        Assertions.assertSame(emDTO,employService.save(emDTO));
        //test update
        emDTO.setId(1L);
        emDTO.setEmail("manh73879@vimaru.edu.vn");
        Mockito.when(employService.save(emDTO)).thenReturn(emDTO);
        Assertions.assertEquals(employService.save(emDTO).getEmail(),"manh73879@vimaru.edu.vn");

    }

}
