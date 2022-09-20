package com.eda.backend.controller;

import com.eda.backend.entitiy.Employee;
import com.eda.backend.model.EmployeeUpdateRequestModel;
import com.eda.backend.repository.EmployeeRepository;
import com.eda.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Sınıfın uygulamanın denetleyici parçası olduğunu gösterir
@RequestMapping("/api") //Verilen URL kalıbı ile karşılaşıldığında yöntemin çağırılması gerektiğini belirtir
public class EmployeeController {
    @Autowired //Kontrolün tersine çevrilmesi içindir.Bağımlılığın kontrolü uygulamaya enjekte edilir veya ters çevrilir
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employee/post") //Yeni bir çalışan yarattık post ile ekledik
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping("/employee") //Girdiğimiz çalışan bilgilerini bize getiriyor
    List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @PutMapping("/employee/{id}") //Girdiğimiz verileri güncellememizi sağlar
    public Employee updateEmployee(@PathVariable Long id,@Validated @RequestBody EmployeeUpdateRequestModel employeeUpdateRequestModel){
        Employee employee = employeeService.update(id,employeeUpdateRequestModel);
        return employee;

    }
    @DeleteMapping("/employee/delete/{id}") //Verileri silmemizi sağlar
    public void deleteEmployee(@PathVariable Long id){
        employeeService.sil(id);
    }
}

