package com.example.demo.service.employee;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nvdat2
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public int deleteById(Long id) {
        return employeeRepository.deleteById(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public int insert(Employee employee) {
        return employeeRepository.insert(employee);
    }
}
