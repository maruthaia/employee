package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.model.Employee;
import com.employee.model.EmployeeAddress;

@EnableMongoRepositories
@Repository
@Transactional
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

	Optional<Employee> findByName(String name);

	
	

	void deleteByName(String name);

	List<Employee> save(List<Employee> emp);

	EmployeeAddress save(EmployeeAddress address);

	@Query("{'employeeAddress.city':?0}")
	List<Employee> findByCity(@Param("city") String city);


	Employee getByName(String name);




	Optional<Employee> findById(String name);

	




	List<Employee> findByJobTitle(String name);



	@Query("{'employeeAddress.state':?0}")
	Employee findByState(@Param("name") String name);



	@Query(value="{'employeeAddress.city':?0}",delete=true)
	void deleteByCity(String city);




	

}
