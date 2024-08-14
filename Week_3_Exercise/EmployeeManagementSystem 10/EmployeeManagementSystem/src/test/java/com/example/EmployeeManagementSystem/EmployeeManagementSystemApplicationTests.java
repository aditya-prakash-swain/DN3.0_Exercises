package com.example.EmployeeManagementSystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.EmployeeManagementSystem.config.PrimaryDataSourceConfig;
import com.example.EmployeeManagementSystem.config.SecondaryDataSourceConfig;

@SpringBootTest
@ContextConfiguration(classes = {PrimaryDataSourceConfig.class, SecondaryDataSourceConfig.class})

class EmployeeManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}

}
