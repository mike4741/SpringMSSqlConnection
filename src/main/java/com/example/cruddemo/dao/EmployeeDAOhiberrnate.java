package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Queue;

@Repository
public class EmployeeDAOhiberrnate implements EmployeeDAO{
    private  final EntityManager entityManager;
    @Autowired
    public  EmployeeDAOhiberrnate(final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
   @Transactional
    public List<Employee> FindAll() {
        Session currentSession = this.entityManager.unwrap((Session.class));
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee",Employee.class);
        List<Employee> emp = theQuery.getResultList();
        return emp;
    }

    @Override
    @Transactional
    public Employee findById(Integer id) {
        Session currentSession = this.entityManager.unwrap((Session.class));
        Employee employee = currentSession.get(Employee.class ,id);
        return employee;
    }
}
