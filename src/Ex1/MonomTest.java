package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void constructorsAndToString (){
		assertEquals(new Monom("1").toString(), "1.0");
		assertEquals(new Monom("-x").toString(), "-1.0x");
		assertEquals(new Monom("2x^5").toString(), "2.0x^5");
		assertEquals(new Monom("-x^3").toString(), "-1.0x^3");
		assertEquals(new Monom("x^0").toString(), "1.0");
		
	
	}
	
	 @Test
	void addAndMultipy (){
		Monom m1 = new Monom("x^5");
		Monom m2 = new Monom("8x^2");
		Monom one = new Monom("1");
		Monom minusone = new Monom("-1");
		Monom Zero = new Monom("0");
		m1.add(m2);
		assertEquals(m1.toString(),new Monom("1.0x^5"));
		m1.multipy(m2);
		assertEquals(m1.toString(), new Monom("8.0x^7"));
		m1 = new Monom("1.0x^5");
		m1.add(one);
		assertEquals(m1.toString(), new Monom("1.0x^5"));
		m1.multipy(one);
		assertEquals(m1.toString(), new Monom("1.0x^5"));
		m1.add(minusone);
		assertEquals(m1.toString(), new Monom("1.0x^5"));
		m1.multipy(minusone);
		assertEquals(m1.toString(), new Monom("-1.0x^5"));
		m1 = new Monom("1.0x^5");
		m1.add(Zero);
		assertEquals(m1.toString(), new Monom("1.0x^5"));
		m1.multipy(Zero);
		assertEquals(m1.toString(), new Monom("0.0"));
	}

}
