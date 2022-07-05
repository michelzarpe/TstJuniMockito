package com.michelzarpe.TstJuniMockito;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Repository
public class EmployeeDao {
    private Map<Integer, EmployeeVO> DB = new HashMap<>();

    public List<EmployeeVO> getEmployeeList()
    {
        List<EmployeeVO> list = new ArrayList<>();
        if(list.isEmpty()) {
            list.addAll(DB.values());
        }
        return list;
    }

    public EmployeeVO getEmployeeById(int id) {
        return DB.get(id);
    }

    public void addEmployee(EmployeeVO employee) {
        employee.setEmployeeId(DB.keySet().size() + 1);
        DB.put(employee.getEmployeeId(), employee);
    }

    public void updateEmployee(EmployeeVO employee) {
        DB.put(employee.getEmployeeId(), employee);
    }

    public void deleteEmployee(int id) {
        DB.remove(id);
    }
}
