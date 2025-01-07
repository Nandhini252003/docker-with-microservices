package com.example.emp_service.controller;

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

import com.example.emp_service.dto.Department;
import com.example.emp_service.dto.EmployeeDepartmentDto;

import com.example.emp_service.entity.Employee;

import com.example.emp_service.services.IEmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {
	
   @Autowired	
   IEmpService empService;
   
   @Autowired
   IDeptClient deptClient;
   
   
   @PostMapping("/create")
   public ResponseEntity<String> saveEmp(@RequestBody Employee emp){
	   empService.saveEmp(emp);
	   return ResponseEntity.status(HttpStatus.CREATED).body("Employee saved with ID: " + emp.getEmpId());
   }
   
   
   @GetMapping("/{empId}")
   public ResponseEntity<EmployeeDepartmentDto> getEmp(@PathVariable Integer empId){
	   
	   Department d = deptClient.getDept(empId);
	   Employee e = empService.getEmp(empId);
	   EmployeeDepartmentDto ed = new EmployeeDepartmentDto();
	   ed.setDeptId(d.getDeptId());
	   ed.setDeptName(d.getDeptName());
	   ed.setEmpId(e.getEmpId());
	   ed.setEmpName(e.getEmpName());
	   return new ResponseEntity<EmployeeDepartmentDto>(ed, HttpStatus.OK); 
   }
   
   
   @PutMapping("/update/{empid}")
   public ResponseEntity<String> updateEmp(@PathVariable Integer empid,@RequestBody EmployeeDepartmentDto edto){
	   
	   try {
	        
	        Department d = deptClient.getDept(empid);
	        
	       
	        if (d != null) {
	        	deptClient.updateDept(empid,edto);
	        }
	        
	    } catch (Exception ex) {
	       
	    }
	   
	   empService.updateEmp(empid,edto);
	  
	   return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");	   
   }
   
   @DeleteMapping("/remove/{eid}")
   public ResponseEntity<String> deleteEmp(@PathVariable Integer eid){
	  
	   
	   try {
	        // Call Feign client to fetch the department associated with the employee
	        Department d = deptClient.getDept(eid);
	        
	        // If department exists, delete it
	        if (d != null) {
	            deptClient.deleteDept(d.getDeptId());
	        }
	    } catch (Exception ex) {
	       
	    }
	   empService.dltEmp(eid);
	   return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted Employee and his details with ID: " + eid);
   }

}
