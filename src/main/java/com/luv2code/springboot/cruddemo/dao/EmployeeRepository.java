package com.luv2code.springboot.cruddemo.dao;

import java.util.List;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public interface EmployeeRepository 
			extends CrudRepository<Employee,Integer> {


	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
}

