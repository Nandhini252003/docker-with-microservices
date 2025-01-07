package com.example.emp_service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp_service.dto.EmployeeDepartmentDto;
import com.example.emp_service.dto.EmployeeDto;
import com.example.emp_service.entity.Employee;
import com.example.emp_service.exceptions.DataNotExistsException;
import com.example.emp_service.repository.EmpRepository;

@Service
public class EmpService implements IEmpService{
	
	@Autowired
	EmpRepository empRepository;

	@Override
	public void saveEmp(Employee employee) {
		
		empRepository.save(employee);
		
	}

	@Override
	public Employee getEmp(Integer empId) {
		Optional<Employee> employeeOptional = empRepository.findById(empId);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new DataNotExistsException("No employee found with the given id: " + empId);
        }
		
	}

	@Override
	public void updateEmp(Integer empid, EmployeeDepartmentDto edto) {
		
		Optional<Employee> employeeOptional = empRepository.findById(empid);
	    if (employeeOptional.isPresent()) {
	       
	        Employee e = employeeOptional.get();
	        e.setEmpName(edto.getEmpName());
	        empRepository.save(e);
	    } else {
	        
	        throw new DataNotExistsException("No employee found with the given id: " + empid);
	    }
		
	}

	@Override
	public void dltEmp(Integer eid) {
		
		Optional<Employee> employeeOptional = empRepository.findById(eid);
	    if (employeeOptional.isPresent()) {
	      
	        //Employee e = employeeOptional.get();
	        empRepository.deleteById(eid);
	    } else {
	       
	        throw new DataNotExistsException("No employee found with the given id: " + eid);
	    }
		
	}

}
