package com.example.emp_service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.emp_service.dto.Department;
import com.example.emp_service.dto.EmployeeDepartmentDto;

@FeignClient(name="dept-service",url = "http://localhost:8085")
public interface IDeptClient {
	

	   @GetMapping("/department/{deptId}")
	   public Department getDept(@PathVariable Integer deptId);
	   
	   
	   @PutMapping("/department/update/{deptid}")
	   public ResponseEntity<String> updateDept(@PathVariable Integer deptid,@RequestBody EmployeeDepartmentDto ddto);


	   @PostMapping("/create")
	   public ResponseEntity<String> saveDept(@RequestBody EmployeeDepartmentDto dept);
		   
	   
	   @DeleteMapping("/department/remove/{dId}")
	   public ResponseEntity<String> deleteDept(@PathVariable Integer dId);
}
