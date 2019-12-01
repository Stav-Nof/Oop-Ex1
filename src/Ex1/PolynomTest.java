package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void ConstructorAndtoString() {
		
		
		assertEquals(new Polynom("x^2+x"), "x^2+x");
		assertEquals(new Polynom("2x^2+5x"), "2x^2+5x");
		assertEquals(new Polynom("-3x^3+7x"), "-3.0x^2+7x");
		assertEquals(new Polynom("x^2+x"), "x^2+x");
		assertEquals(new Polynom("-x^4+5x^4"), "-1.0x^4+5x^4");
		
		
	}
	
	void AddPolynoms() {
		
		Polynom p1 = new Polynom("3x^5+2x^4-x");
		Polynom p2 = new Polynom("10x^5+4x^4-2x");
		Polynom p3 = new Polynom("3x^6+2x^4+x^2");
		Polynom p4 = new Polynom("4x^3+2x^2-x");
		Polynom p5 = new Polynom("-5x^5+2x^2+3x");
		Polynom p6 = new Polynom("5x^5-2x^2-3x");
		Polynom p7 = new Polynom("5x^3+0x^3+1");
		Polynom Zero = new Polynom("0");
		Polynom p8 = new Polynom("x^3+0x^2");
		
		
		p2.add(p4);
		p3.add(p3);
		p5.add(p6);
		p7.add(Zero);
		p8.add(Zero);
		assertEquals(p2.toString(),"10.0x^5+4.0x^4+4.0x^3+2.0x^2-3.0x");
		assertEquals(p5.toString(), "0");
		assertEquals(p3.toString(), "6.0x^6+4.0x^4+2.0x^2");
		assertEquals(p7.toString(), "5.0x^3+1");
		assertEquals(p8.toString(), "1.0x^3" );
		
		
	}

}
