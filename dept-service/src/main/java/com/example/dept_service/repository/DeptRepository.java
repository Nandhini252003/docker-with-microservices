package com.example.dept_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dept_service.entity.Department;

public interface DeptRepository extends JpaRepository<Department, Integer>{

}
