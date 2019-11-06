import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee() {
            @Override
            protected double getMonthSalary(int hoursPerMonth) {
                return 0;
            }
        };
    }

    @After
    public void tearDown() throws Exception {
        employee = null;
    }

    @Test
    public void getHoursPercent() {
        employee.salaryPerMonth = 10000;
        employee.workedHours = 50;
        assertEquals(50, employee.getHoursPercent(100), 0);
    }
}