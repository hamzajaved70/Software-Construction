package lab2;
import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {

	@Test
	public void testPopulate() {
		Matrix m1 = new Matrix(4,4);
		Multiply mul = new Multiply();
		m1 = mul.populate(m1,m1.getRow(),m1.getRow());
		assertEquals(4,m1.getRow());
	}
	@Test
	public void testiterativeMultiply(){
		Matrix m1 = new Matrix(4,4);
		Matrix m2 = new Matrix(4,4);
		Multiply mul = new Multiply();
		m1 = mul.iterativeMultiply(m1,m2,m1.getRow(),m1.getRow(),m1.getRow());
		assertEquals(4,m1.getRow());
	}
}