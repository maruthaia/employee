package com.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping(value = "/employee")
	private ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
		logger.info("Passed To post Method in Service Layer.");
		return new ResponseEntity<>(employeeService.postEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping(value = "/employee/{jobTitle}")
	public ResponseEntity<?> getEmployee(@PathVariable String jobTitle) {
		ResponseEntity responseEntity = null;
		logger.info("Passed To Get Method in Service Layer.");
		responseEntity = new ResponseEntity<>(employeeService.getEmployee(jobTitle), HttpStatus.OK);
		logger.info("Passed To Get Method in Service Layer.");
		return responseEntity;
	}

	@GetMapping(value = "/employeeAddress/{city}")
	public ResponseEntity<?> getEmployeeAddress(@PathVariable String city) {
		ResponseEntity responseEntity = null;
		logger.info("Passed To Get Method in Service Layer.");
		responseEntity = new ResponseEntity<>(employeeService.getEmployeeAddress(city), HttpStatus.OK);
		logger.info("Passed To Get Method in Service Layer.");
		return responseEntity;
	}

	@GetMapping(value = "/employee")
	public ResponseEntity<?> getEmployees() {
		ResponseEntity responseEntity = null;
		logger.info("Passed To Get Method in Service Layer.");
		responseEntity = new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(value = "/employee/{name}")
	public ResponseEntity<?> putEmployee(@RequestBody Employee employee, @PathVariable String name) {
		ResponseEntity responseEntity = null;
		logger.info("Passed To put Method in Service Layer.");
		responseEntity = new ResponseEntity<>(employeeService.putEmployee(employee, name), HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(value = "/employeeAddress/{state}")
	public ResponseEntity<?> putAddress(@RequestBody Employee employee, @PathVariable String state) {
		ResponseEntity responseEntity = null;
		logger.info("Passed To put Method in Service Layer.");
		responseEntity = new ResponseEntity<>(employeeService.putAddress(employee, state), HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(value = "/employee/{name}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String name) {
		ResponseEntity responseEntity = null;
		logger.info("Passed To delete Method in Service Layer.");
		employeeService.deleteEmployee(name);
		responseEntity = new ResponseEntity<>("employee data is deleted", HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(value = "/employeeAddress/{city}")
	public ResponseEntity<?> deleteAddress(@PathVariable String city) {
		ResponseEntity responseEntity = null;
		logger.info("Passed To delete Method in Service Layer.");
		employeeService.deleteAddress(city);
		responseEntity = new ResponseEntity<>("address data is deleted", HttpStatus.OK);
		return responseEntity;
	}

}
