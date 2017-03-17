package lab3;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookingTest {
    
    public BookingTest() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Booking b2 = new Booking("Hamza", 10, "2812", "1400");
        assertEquals("Hamza", b2.getName());
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Booking b3 = new Booking("Hamza", 10,"2812", "1400");
        assertEquals("1400", b3.getTime());
    }

    @Test
    public void testGetGuests() {
        System.out.println("getGuests");
        Booking b4 = new Booking("Hamza", 10,"2812" ,"1400");
        assertEquals(10, b4.getGuests());
    }
}
