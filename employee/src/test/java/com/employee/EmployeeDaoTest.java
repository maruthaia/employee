package com.employee;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;
import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testCreateEmployee(){

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setName("Maran");
		employee.setAge(22);
		employee.setJobTitle("manager");
		employee.setPlace("trichy");
		employee.setPhoneNumber(123344);
		
	    Mockito.when(employeeDao.postEmployee(employee)).thenReturn(employee);
	    
	    assertThat(employeeRepository.save(employee)).isEqualTo(employee);
	
	}
	
	@Test
	public void testGetEmployee(){
		Employee employee = new Employee();
		employee.setEmpId(2);
		employee.setName("marii");
		employee.setAge(22);
		employee.setJobTitle("manager");
		employee.setPlace("trichy");
		employee.setPhoneNumber(123344);
		List<Employee> emp = new ArrayList<>();
		emp.add(employee);
		Mockito.when(employeeDao.getEmployees()).thenReturn(emp);
		
		assertThat(employeeRepository.findAll()).isEqualTo(emp);
	}
	
	
	@Test
	public void testDeleteEmployee(){
		employeeRepository.deleteById(4);
		assertThat(employeeRepository.existsById(1)).isFalse();
	}
		
	@Test
	public void testUpdateEmployee() {
		Employee employee = new Employee();
		employee.setEmpId(6);
		employee.setName("raj");
		employee.setAge(26);
		employee.setJobTitle("manager");
		employee.setPlace("trichy");
		employee.setPhoneNumber(123344);
	    
	    when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

	    Employee savedCustomer = employeeRepository.save(employee);
	    assertThat(savedCustomer.getName()).isNotNull();

	    }
		
	}
	
	
	
