package com.example.emp_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp_service.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
