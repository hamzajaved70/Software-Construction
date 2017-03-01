package lab3;

import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {
    
    public TableTest() {
    }
    
    @Test
    public void testGetId() {
        System.out.println("getId");
        Table t1 = new Table(2,20);
        assertEquals(2,t1.getId());
    }

    @Test
    public void testGetSeats() {
        System.out.println("getSeats");
        Table t1 = new Table(2,20);
        assertEquals(20, t1.getSeats());
    }
    
}
