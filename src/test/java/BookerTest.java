import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookerTest {
    private Booker booker;
    private List<Employee> employees;

    @Before
    public void setUp() throws Exception {
        booker = new Booker();
        employees = new ArrayList<>();
        Employee employee1 = new Proger("Ivanov", 10000, 100);
        Employee employee2 = new Manager("Petrov", 2000, 50);
        Employee employee3 = new Manager("Sidorov", 1000, 20);

        employee1.setWorkedHours(50);
        employee2.setWorkedHours(100);
        employee3.setWorkedHours(10);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @Test
    public void calculateSalary() {
        booker.setEmployees(employees);
        assertEquals(7500.0, booker.calculateSalary(), 0);
    }

    @After
    public void tearDown() throws Exception {
        booker = null;
    }
}