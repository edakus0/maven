package com.eda.backend.repository;

import com.eda.backend.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Bu arayüzün proje için depo tanımlayacağını belirtir
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
