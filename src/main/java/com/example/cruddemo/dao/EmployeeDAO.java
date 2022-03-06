package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDAO   {
    public List<Employee> FindAll() ;
    public  Employee findById(Integer id);
}
