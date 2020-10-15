package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationTest implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting -> {}", employeeRepository.insert(new Employee("Ramesh", "Fadatare", "ramesh@gmail.com")));

        logger.info("Employee id 1 -> {}",employeeRepository.findById(1L));

        logger.info("Update 4 -> {}",employeeRepository.update(new Employee("Ramesh1", "Fadatare1", "ramesh@gmail.com")));

        employeeRepository.deleteById(4L);

        logger.info("All users -> {}", employeeRepository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }
}
