package com.example.demo.controllerTest;

import com.example.demo.controller.employeeController;
import com.example.demo.dto.employeeDTO;
import com.example.demo.service.employeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@WebMvcTest(employeeController.class)
public class controllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private employeeDTO emDTO;
    @MockBean
    private employeeService emSer;
    /**
     * Đối tượng MockMvc do Spring cung cấp
     * Có tác dụng giả lập request, thay thế việc khởi động Server
     */

    @Test
    public void addEmployeeControllerTest() throws Exception {

        emDTO=new employeeDTO("manh","le sy duc","manh@gmail.com");
        Mockito.when(emSer.save(emDTO)).thenReturn(emDTO);
        mvc.perform(post("/api/employees")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(emDTO))
                .with(csrf()))
                .andExpect(status().isCreated());
    }
}
