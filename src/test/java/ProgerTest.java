import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgerTest {
    private Proger proger;

    @Before
    public void setUp() throws Exception {
        proger = new Proger("Ivanov", "+380",10000, 100);
    }

    @After
    public void tearDown() throws Exception {
        proger = null;
    }

    @Test
    public void getMonthSalary() {
        assertEquals(5000.0, proger.getMonthSalary(200), 0.0);
    }
}