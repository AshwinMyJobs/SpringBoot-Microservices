package com.eam.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.eam.entity.Emp_Dept;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class EmpDeptRepositoryTest {
	
	@Autowired
	EmpDeptRepository empDeptRepository;
	

	@Test
	public void save() {
		Emp_Dept emp_Dept = Emp_Dept.builder().empId(1L).deptId(1L).build();
		
		empDeptRepository.save(emp_Dept);
		
		assertThat(emp_Dept.getId()).isGreaterThan(0);
		assertThat(emp_Dept.getEmpId()).isEqualTo(1L);
		assertThat(emp_Dept.getDeptId()).isEqualTo(1L);
				
	}

}
