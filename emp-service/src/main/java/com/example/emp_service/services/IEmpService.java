package com.example.emp_service.services;

import com.example.emp_service.dto.EmployeeDepartmentDto;
import com.example.emp_service.entity.Employee;

public interface IEmpService {

	public void saveEmp(Employee employee);
	
	public Employee getEmp(Integer empId);

	public void updateEmp(Integer empid, EmployeeDepartmentDto edto);

	public void dltEmp(Integer eid);
}
