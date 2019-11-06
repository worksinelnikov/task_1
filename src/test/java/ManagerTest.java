import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    private Manager manager;
    @Before
    public void setUp() throws Exception {
        manager = new Manager("Petrov", "+380",10000, 50);
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void getMonthSalary() {
        assertEquals(5000, manager.getMonthSalary(100), 0);
        assertEquals(10000, manager.getMonthSalary(10), 0);
    }
}