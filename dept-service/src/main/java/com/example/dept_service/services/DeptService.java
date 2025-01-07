package com.example.dept_service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dept_service.dto.DepartmentDto;
import com.example.dept_service.entity.Department;
import com.example.dept_service.exception.DepartmentNotFoundException;
import com.example.dept_service.repository.DeptRepository;

@Service
public class DeptService implements IDeptService {

	@Autowired
	DeptRepository deptRepository;

	@Override
	public void saveDept(Department department) {
		deptRepository.save(department);
	}

	@Override
	public Department getDept(Integer deptId) {

		Optional<Department> deptOptional = deptRepository.findById(deptId);
		if (deptOptional.isPresent()) {

			return deptOptional.get();
		} else {

			throw new DepartmentNotFoundException("No department found with the given id: " + deptId);
		}

	}

	@Override
	public void updateDept(Integer deptid, DepartmentDto ddto) {

		Optional<Department> deptOptional = deptRepository.findById(deptid);
		if (deptOptional.isPresent()) {

			Department d = deptOptional.get();
			d.setDeptName(ddto.getDeptName());
			deptRepository.save(d);
		} else {

			throw new DepartmentNotFoundException("No department found with the given id: " + deptid);
		}

	}

	@Override
	public void dltDept(Integer dId) {

		Optional<Department> deptOptional = deptRepository.findById(dId);
		if (deptOptional.isPresent()) {

			// Employee e = employeeOptional.get();
			deptRepository.deleteById(dId);
		} else {

			throw new DepartmentNotFoundException("No department found with the given id: " + dId);
		}

	}

}
