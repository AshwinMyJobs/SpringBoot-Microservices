package com.eam.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.eam.entity.Department;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	public void saveDepartment() {
		
		Department department = Department.builder()
				.deptName("TestDepartment")
				.description("TestDepartment")
				.build();
		
		departmentRepository.save(department);
		
		assertThat(department.getDeptid()).isGreaterThan(0);
	}
}
