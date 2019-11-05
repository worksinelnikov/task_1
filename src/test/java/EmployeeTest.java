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
            protected double getMonthSalary() {
                return 0;
            }

            @Override
            public void setWorkedHours(double workedHours) {

            }
        };
    }

    @After
    public void tearDown() throws Exception {
        employee = null;
    }

    @Test
    public void getHoursPercent() {
        employee.setHours(200);
        assertEquals(25, employee.getHoursPercent(50), 0);
    }
}