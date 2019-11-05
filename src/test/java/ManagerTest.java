import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    private Manager manager;
    @Before
    public void setUp() throws Exception {
        manager = new Manager("Petrov", 10000, 100);
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void getMonthSalary() {
        manager.setWorkedHours(150);
        assertEquals(10000, manager.getMonthSalary(), 0);
    }
}