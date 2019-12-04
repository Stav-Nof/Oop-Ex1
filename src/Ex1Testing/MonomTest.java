package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;

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
		Monom m2 = new Monom("-5x^5");
		Monom m3 = new Monom("8x^3");
		Monom one = new Monom("1");
		Monom minusone = new Monom("-1");
		Monom Zero = new Monom("0");
		/*
		 *******************Tests for add function************************
		 */
	
		m1.add(m3);
		assertEquals(m1.toString() , new Monom("x^5").toString());
		m1.add(m1);
		assertEquals(m1.toString(),new Monom("2.0x^5").toString());
		m1.add(m2);
		assertEquals(m1.toString(), new Monom("-3.0x^5").toString());
		Monom m4 = new Monom ("4x^5");
		m1.add(m4);
		assertEquals(m1.toString() , new Monom("x^5").toString());
		m1.add(Zero);
		assertEquals(m1.toString() , new Monom ("x^5").toString());
		Zero.add(m2);
		assertEquals(Zero.toString() , new Monom ("-5x^5").toString());
		Monom m7 = new Monom("0");
		m7.add(one);
		Monom m8 = new Monom ("-6x^5");
		m8.add(Zero);
		assertEquals(m8.toString() , new Monom ("-11.0x^5").toString());
		Monom mOne = new Monom("-1");
		mOne.add(mOne);
		assertEquals(mOne.toString() , new Monom ("-2.0").toString());
		mOne.add(one);
		assertEquals(mOne.toString() , new Monom ("-1.0").toString());
		
		/*
		 ************************Tests for Multiply function*************
		 */
		
		m1.multipy(m3);
		assertEquals(m1.toString() , new Monom ("8.0x^8").toString());
		m1.multipy(m1);
		assertEquals(m1.toString() , new Monom ("64.0x^16").toString());
		m1.multipy(one);
		assertEquals(m1.toString() , new Monom ("64.0x^16").toString());
		m1.multipy(minusone);
		assertEquals(m1.toString() , new Monom ("-64.0x^16").toString());
		Monom zero = new Monom("0");
		m1.multipy(zero);
		assertEquals(m1.toString() , new Monom ("0").toString());
		m2.multipy(m2);
		assertEquals(m2.toString() , new Monom ("25.0x^10").toString());
		Monom m5 = new Monom ("-10x^2");
		m2.multipy(m5);
		assertEquals(m2.toString() , new Monom ("-250.0x^12").toString());
		Monom m6 = new Monom ("2");
		m2.multipy(m6);
		assertEquals(m2.toString() , new Monom ("-500.0x^12").toString());
		m2.multipy(minusone);
		assertEquals(m2.toString() , new Monom ("500.0x^12").toString());
		
	
	}
	 
	 @Test
	 void Equals() {
		 
		 
		 	Monom m1 = new Monom("x^5");
			Monom m2 = new Monom("-5x^5");
			Monom m3 = new Monom("8x^3");
			Monom m4 = new Monom("8.0x^3");
			Monom m5 = new Monom ("-5.0x^5");
			Monom one = new Monom("1");
			Monom One = new Monom("1");
			Monom minusone = new Monom("-1");
			Monom minusOne = new Monom("-1");
			Monom Zero = new Monom("0");
			
			
			assertTrue(m1.equals(m1));
			assertFalse(m1.equals(m2));
			assertTrue(m3.equals(m4));
			assertTrue(m2.equals(m5));
			assertTrue(one.equals(One));
			assertTrue(minusone.equals(minusOne));
			
			
		 
	 }
	 @Test
	 void substract() {
		 
		 
		 	Monom m1 = new Monom("x^5");
			Monom m2 = new Monom("-5x^5");
			Monom m3 = new Monom("8x^3");
			Monom m4 = new Monom("8.0x^3");
			Monom m5 = new Monom ("-5x^5");
			Monom m6 = new Monom ("-11x^5");
			Monom m7 = new Monom ("14x^5");
			Monom m8 = new Monom ("0x");
			Monom one = new Monom("1");
			Monom One = new Monom("1");
			Monom minusone = new Monom("-1");
			Monom minusOne = new Monom("-1");
			Monom Zero = new Monom("0");
			
			
			m1.substract(m2);
			assertEquals(m1.toString() , new Monom("6.0x^5").toString());
			m2.substract(m5);
			assertEquals(m2.toString() , new Monom("0").toString());
			m1.substract(m3);
			assertEquals(m1.toString() , new Monom("6.0x^5").toString());
			m1.substract(one);
			assertEquals(m1.toString() , new Monom("6.0x^5").toString());
			m1.substract(m6);
			assertEquals(m1.toString() , new Monom("17.0x^5").toString());
			m6.substract(m7);
			assertEquals(m6.toString() , new Monom("-25.0x^5").toString());
			m7.substract(m1);
			assertEquals(m7.toString() , new Monom("-3.0x^5").toString());
			m8.substract(m7);
			assertEquals(m8.toString() , new Monom("3.0x^5").toString());
			one.substract(minusOne);
			assertEquals(one.toString() , new Monom("2").toString());
			minusone.substract(One);
			assertEquals(minusone.toString() , new Monom("-2").toString());
			
			
			
				
	 }
	 
	
	 
	 

}