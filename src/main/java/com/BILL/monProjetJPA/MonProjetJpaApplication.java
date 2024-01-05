package com.BILL.monProjetJPA;

import com.BILL.monProjetJPA.model.Employee;
import com.BILL.monProjetJPA.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@RestController
public class MonProjetJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonProjetJpaApplication.class, args);
	}


//	@GetMapping
//	public List<Employee> salut() {
//		return List.of(
//				new Employee("Bill","armistrong","bill.imad@gmail.dz",45,"Manager"),
//				new Employee("imad","kevin","imad.kevine@gmail.mc",45,"developer")
//		);
//	}


//	@Bean
//	CommandLineRunner commandLineRunner (EmployeeRepository employeeRepository)
//	{
//		return  args -> {
//			employeeRepository.save(new Employee("Bill","armistrong","bill.imad@gmail.dz",45,"Manager"));
//
//		};
//	}
}
