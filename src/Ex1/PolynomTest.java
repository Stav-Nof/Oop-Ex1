package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void ConstructorAndtoString() {
		assertEquals((new Polynom("1+x+x^2+x^3+x^4")).toString(), new Polynom("x^4+x^3+x^2+x+1").toString());
		assertEquals((new Polynom("2x")).toString(), new Polynom("x-5x+3x-x+2x").toString());
		assertEquals((new Polynom("x")).toString(), new Polynom("1x^1").toString());
		assertEquals((new Polynom("-2x")).toString(), new Polynom("-x-x").toString());
		assertEquals((new Polynom("x+4+x^2+2x^2+5+5x")).toString(), new Polynom("3x^2+6x+9").toString());
	}
	@Test
	void AddPolynomsCopyAndEquals() {
		Polynom p1 = new Polynom("3x^5+2x^4-x");
		Polynom p2 = new Polynom("10x^5+4x^4-2x");
		Polynom p3 = new Polynom("3x^6+2x^4+x^2");
		Polynom p4 = new Polynom("4x^3+2x^2-x");
		Polynom p1c = (Polynom) p1.copy();
		Polynom p2c = (Polynom) p2.copy();
		Polynom p3c = (Polynom) p3.copy();
		Polynom p4c = (Polynom) p4.copy();
		assertTrue(p1.equals(p1c));
		assertTrue(p2.equals(p2c));
		assertTrue(p3.equals(p3c));
		assertTrue(p4.equals(p4c));
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p4c.add(p3c);
		p4c.add(p2c);
		p4c.add(p1c);
		assertTrue(p1.equals(p4c));
	}
	
	
	@Test
	void substract() {
		Polynom p1 = new Polynom("3x^5+2x^4-x");
		Polynom p2 = new Polynom("3x^5");
		Polynom p1ans = new Polynom("2x^4-x");
		p1.substract(p2);
		assertEquals(p1.toString(), p1ans.toString());
		Polynom p3 = new Polynom("3x^6+2x^4+x^2");
		Polynom p4 = new Polynom("4x^3+2x^2-x");

	}
}
