package com.employee.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.employee.model.Employee;
import com.employee.model.EmployeeAddress;
import com.employee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Component
public class EmployeeDao {
	@Autowired
	private EmployeeRepository employeerepository;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);

	public Employee postEmployee(Employee employee) {
		logger.info("post the employee data");

		return employeerepository.save(employee);
	}

	public List<Employee> getEmployees() {
		logger.info("get the employees data");
		return employeerepository.findAll();
	}

	public List<Employee> getEmployee(String jobTitle) {
		logger.info("get the employees data");
		return employeerepository.findByJobTitle(jobTitle);
	}

	public Employee putEmployee(Employee employee, String name) {
		Employee emp = employeerepository.findByName(name).get();
		logger.info("update the employees data {}",emp.toString() );
		emp.setAge(employee.getAge());
		emp.setJobTitle(employee.getJobTitle());
		emp.setPlace(employee.getPlace());
		emp.setPhoneNumber(employee.getPhoneNumber());
		emp.setEmailId(employee.getEmailId());
		emp.setGender(employee.getGender());
		emp.setPhoneNumber(employee.getPhoneNumber());
		emp.setPlace(employee.getPlace());
		return employeerepository.save(emp);
	}

	public void deleteEmployee(String name) {
		logger.info("delete the employee  data");
		employeerepository.deleteByName(name);
	}

	public List<Employee> getEmployeeAddress(String city) {
		logger.info("get the employees data");
		return employeerepository.findByCity(city);
	}

	public  Employee putAddress(Employee employee, String state) {
		Employee emp = employeerepository.findByState(state);
		logger.info("update the employees data {}",emp.toString() );
		EmployeeAddress address = employee.getEmployeeAddress();
		EmployeeAddress addressdb = emp.getEmployeeAddress();
		addressdb.setVillageName(address.getVillageName());
		addressdb.setCity(address.getCity());
		addressdb.setCountry(address.getCountry());
		addressdb.setState(address.getState());
		return employeerepository.save(emp);
		
	}

	public void deleteAddress(String city) {
		logger.info("delete the employee  data");
		employeerepository.deleteByCity(city);
	}

}
