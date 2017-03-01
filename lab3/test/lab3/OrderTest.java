package lab3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {
    
    public OrderTest() {
    }
    

    @Test
    public void testAssignTable() {
        System.out.println("assignTable");
        Restaurant rest = new Restaurant(11, 22);
        Order or = new Order(rest);
        assertEquals(3,or.assignTable(5,12));
    }
    
}
