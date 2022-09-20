package com.eda.backend.service;

import com.eda.backend.entitiy.Employee;
import com.eda.backend.model.EmployeeUpdateRequestModel;
import com.eda.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service //Bu sınıfın kullanıcı hizmetini sağladığını gösterir
public class EmployeeService {
    @Autowired //Kontrolün tersine çevrilmesi için
    EmployeeRepository employeeRepository;

    //Save ile kaydetmemizi sağlar
    public void save(Employee employee) {
            employeeRepository.save(employee);
    }

    //Çalışanları listelememizi sağlar
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    //Update yapmamızı sağlayan fonksiyon
    public Employee update(Long id, EmployeeUpdateRequestModel employeeUpdateRequestModel) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        employee.setEmployeeName(employeeUpdateRequestModel.getEmployeeName());
        employee.setEmployeeLastname(employeeUpdateRequestModel.getEmployeeLastname());
        employee.setEmployeeEmail(employeeUpdateRequestModel.getEmployeeEmail());
        employee.setEmployeePhone(employeeUpdateRequestModel.getEmployeePhone());
        employee.setEmployeeDepartment(employeeUpdateRequestModel.getEmployeeDepartment());
        employeeRepository.save(employee);
        return employee;
    }
    //Silme işlemini yapmamızı sağlayan fonksiyon
    public void sil(Long id) {
        employeeRepository.deleteById(id);
    }


}
