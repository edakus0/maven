package com.eda.backend.model;

import lombok.Data;

@Data //verileri çekiyoruz
public class EmployeeUpdateRequestModel {
    String employeeName;
    String employeeLastname;
    String employeeEmail;
    String employeePhone;
    String employeeDepartment;

}
