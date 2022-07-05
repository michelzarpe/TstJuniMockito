package com.michelzarpe.TstJuniMockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager {
    @Autowired
    EmployeeDao dao;

    public List<EmployeeVO> getEmployeeList() {
        return dao.getEmployeeList();
    }

    public EmployeeVO getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    public void addEmployee(EmployeeVO employee) {
        dao.addEmployee(employee);
    }
}
