package com.example.demo.controller;

import com.example.demo.dto.response.MesseageResponse;
import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nvdat2
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id){
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MesseageResponse> insertEmployee(@RequestBody Employee employee){
        employeeService.insert(employee);
        return new ResponseEntity<>(new MesseageResponse("Insert employee successfully!"), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MesseageResponse> updateEmployee(@RequestBody Employee employee){
        employeeService.update(employee);
        return new ResponseEntity<>(new MesseageResponse("Update employee successfully!"),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MesseageResponse> deleteById(@PathVariable("id") Long id){
        return new ResponseEntity<>(new MesseageResponse("Delete employee successfully!"),HttpStatus.NO_CONTENT);
    }
}
