package com.example.dept_service.services;

import com.example.dept_service.dto.DepartmentDto;
import com.example.dept_service.entity.Department;

public interface IDeptService {
	
    public void saveDept(Department department);
	
	public Department getDept(Integer deptId);



	public void updateDept(Integer deptid, DepartmentDto ddto);

	public void dltDept(Integer dId);

}
