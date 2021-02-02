package com.example.demo.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class employeeDTO extends AbstractDTO<employeeDTO> {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email(message = "Type email")
    private String email;


    public employeeDTO() {
        super();
    }

    public employeeDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
