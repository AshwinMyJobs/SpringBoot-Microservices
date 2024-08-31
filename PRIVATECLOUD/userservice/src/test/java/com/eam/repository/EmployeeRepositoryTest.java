package com.eam.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.eam.entity.Employee;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void saveEmployee() {
		Employee employee = Employee.builder()
				.firstName("firstName")
				.lastName("lastName")
				.address("address")
				.build();
		
		employeeRepository.save(employee);
		
		assertThat(employee.getEmpid()).isGreaterThan(0);
		assertThat(employee.getFirstName()).isEqualTo("firstName");
		assertThat(employee.getEmailid()).isNull();
	}
	
}
