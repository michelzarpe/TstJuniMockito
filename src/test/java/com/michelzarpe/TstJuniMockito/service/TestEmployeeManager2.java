package com.michelzarpe.TstJuniMockito.service;

import com.michelzarpe.TstJuniMockito.EmployeeDao;
import com.michelzarpe.TstJuniMockito.EmployeeManager;
import com.michelzarpe.TstJuniMockito.EmployeeVO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestEmployeeManager2 {

    @InjectMocks
    EmployeeManager manager;

    @Mock
    EmployeeDao dao;

    @BeforeAll
    void setUp(){
        manager = new EmployeeManager(dao);
    }

    @BeforeEach
    void setMockOutPut(){
        List<EmployeeVO> list = new ArrayList<>();
        EmployeeVO empOne = new EmployeeVO(1, "John", "John", "howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2, "Alex", "kolenchiski", "alexk@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3, "Steve", "Waugh", "swaugh@gmail.com");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(dao.getEmployeeList()).thenReturn(list);
    }

    @DisplayName("Test Spring Integration")
    @Test
    void layerService() {
        List<EmployeeVO> empList = manager.getEmployeeList();
        assertEquals(3, empList.size());
        verify(dao, times(1)).getEmployeeList();
    }

}
