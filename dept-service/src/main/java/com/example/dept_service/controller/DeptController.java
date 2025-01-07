package com.example.dept_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dept_service.dto.DepartmentDto;
import com.example.dept_service.entity.Department;
import com.example.dept_service.services.IDeptService;



@RestController
@RequestMapping("/department")
public class DeptController {
	
	@Autowired
	IDeptService deptService;
	
	
	@PostMapping("/create")
	   public ResponseEntity<String> saveDept(@RequestBody Department dept){
		   deptService.saveDept(dept);
		   return ResponseEntity.status(HttpStatus.CREATED).body("Department saved successfully");
	   }
	

	   @GetMapping("/{deptId}")
	   public ResponseEntity<Department> getDept(@PathVariable Integer deptId){
		   
		   return new ResponseEntity<>(deptService.getDept(deptId), HttpStatus.OK); 
	   }

	   
	   @PutMapping("/update/{deptid}")
	   public ResponseEntity<String> updateDept(@PathVariable Integer deptid,@RequestBody DepartmentDto ddto){
		   deptService.updateDept(deptid,ddto);
		   return ResponseEntity.status(HttpStatus.CREATED).body("Updated Successfully");	   
	   }
	   
	   @DeleteMapping("/remove/{dId}")
	   public ResponseEntity<String> deleteDept(@PathVariable Integer dId){
		  deptService.dltDept(dId);
		   return ResponseEntity.status(HttpStatus.CREATED).body("Successfully dleted department with ID: " + dId);
	   }

}
