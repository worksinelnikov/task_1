import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
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
        Employee employee1 = new Proger("Ivanov", "+380", 10000, 100);
        Employee employee2 = new Manager("Petrov", "+380", 2000, 50);
        Employee employee3 = new Manager("Sidorov", "+380", 1000, 120);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @Test
    public void calculateSalary() {
        booker.setEmployees(employees);
        assertEquals(12000.0, booker.calculateSalary(100), 0);
    }

    @Test
    public void writeToXml() throws IOException {
        booker.setEmployees(employees);
        assertTrue(booker.writeToXml("test"));
    }

    @Test
    public void readFromXml() throws IOException {
        assertTrue(booker.readFromXml("test"));
    }

    @After
    public void tearDown() throws Exception {
        booker = null;
    }
}