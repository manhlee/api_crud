package com.example.demo.controller.EmployeePaginate;

import com.example.demo.dto.employeeDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeePaginateOutput {
    private int page;
    private int totalPage;
    private List<employeeDTO> listResult= new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<employeeDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<employeeDTO> listResult) {
        this.listResult = listResult;
    }
}
