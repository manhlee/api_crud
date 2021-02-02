package com.example.demo.controller;

import com.example.demo.controller.EmployeePaginate.EmployeePaginateOutput;
import com.example.demo.dto.employeeDTO;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class employeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/employees")
    public ResponseEntity<?> getEmployee(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit",required = false) Integer limit){

        if(page!=null) {
            if(limit==null){
                limit=3;
            }
            EmployeePaginateOutput resutl = new EmployeePaginateOutput();
            resutl.setPage(page);
            resutl.setListResult(employeeService.findAll(PageRequest.of(page - 1, limit)));
            resutl.setTotalPage((int) Math.ceil((double) (employeeService.totalItem()) / limit));
            return ResponseEntity.status(HttpStatus.OK).body(resutl);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
        }

    }
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") long idEm)
    {

        return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employeeService.getById(idEm)));
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody employeeDTO model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(model));
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody employeeDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(employeeService.save(model));
    }

    @DeleteMapping(value = "/employees")
    public ResponseEntity<?> deleteEmployee(@RequestBody long[] ids) {

        employeeService.delete(ids);
        return ResponseEntity.noContent().header("Content-Length", "0").build();
    }
    @DeleteMapping(value = "employees/{id}")
    public ResponseEntity<?> deleteOneEmployee(@PathVariable("id") long idEm){
        employeeService.delete(idEm);
        return ResponseEntity.noContent().header("Content-Length", "0").build();
    }
}
