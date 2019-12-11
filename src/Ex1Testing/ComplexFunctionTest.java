package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Operation;
import Ex1.Polynom;
import Ex1.function;

class ComplexFunctionTest {

	@Test
	void firstConstructor() {
		
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","x-2", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Monom m = new Monom("2x^2");
		Monom m1 = new Monom("-x");
		Polynom p3 = new Polynom("3x^2-5x+2");
		Polynom p4 = new Polynom("2x^2+5x");
		
		
		
			ComplexFunction cf = new ComplexFunction("div",p1,p2);
			ComplexFunction cf1 = new ComplexFunction("div",p1,p2);
			ComplexFunction cf2 = new ComplexFunction("plus",new Polynom(s3[1]), p2 );
			ComplexFunction cf3 = new ComplexFunction("div(mul(2x^2,3x^2-5x+2),-x)");
			ComplexFunction cf4 = new ComplexFunction("mul(2x^2,3x^2-5x+2)");
			ComplexFunction cf5 = new ComplexFunction("div", cf4, m1 );
			ComplexFunction cf6 = new ComplexFunction("div(mul(2x,3x^2-5x+2),-x");
			ComplexFunction cf7 = new ComplexFunction("div(3.1+2.4x^2-x^4,5+2x-3.3x+0.1x^5)" );
			
//			assertTrue(cf.equals(cf1));
//			assertTrue(cf5.equals(cf3));
			assertNotEquals(cf3.toString(),cf6.toString());
			assertEquals(cf7.toString(), cf.toString());
			
		
			

		
			
	}

	@Test
	void secondConstructor() {
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","x-2", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Monom m = new Monom("4x^2");
		Monom m1 = new Monom("-2x");
		Monom m2 = new Monom("4x^5");
		Monom m3 = new Monom("-2x^4");
		Polynom p3 = new Polynom("3x^2-5x+2");
		Polynom p4 = new Polynom("2x^2+5x");
		
		
		
			ComplexFunction cf = new ComplexFunction(Operation.Divid,m,m1);
			
			ComplexFunction cf1 = new ComplexFunction(Operation.Divid,m2,m3);
			
			ComplexFunction cf2 = new ComplexFunction(Operation.Times,new Polynom(s3[1]), p2);
			ComplexFunction cf3 = new ComplexFunction(Operation.Max, new Polynom(s3[0]), p4);
			
			ComplexFunction cf4 = new ComplexFunction("max", new Polynom(s3[0]), p4 );
			ComplexFunction cf5 = new ComplexFunction("div", cf4, m1 );
			
		assertFalse(cf.equals(cf1));
		//assertEquals(cf3,cf4);
		
		
		
		
		
		
		
	}

	@Test
	void thirdConstructor() {
		
		
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","x-2", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Monom m = new Monom("4x^2");
		Monom m1 = new Monom("-2x");
		Monom m2 = new Monom("4x^5");
		Monom m3 = new Monom("-2x^4");
		Polynom p3 = new Polynom("3x^2-5x+2");
		Polynom p4 = new Polynom("2x^2+5x");
		String s4 = "mul(3x^2,5x)";
		
		
			ComplexFunction cf = new ComplexFunction(Operation.Divid,m,m1);
			
			ComplexFunction cf1 = new ComplexFunction(Operation.Divid,m2,m3);
			
			ComplexFunction cf2 = new ComplexFunction(Operation.Times,new Polynom(s3[1]), p2);
			
			ComplexFunction cf3 = new ComplexFunction(Operation.Max, new Polynom(s3[0]), p4);

			ComplexFunction cf4 = new ComplexFunction("max", new Polynom(s3[0]), p4 );
			
			ComplexFunction cf5 = new ComplexFunction("div", cf4, m1 );
			
			function f = cf.initFromString(s4);
			f.toString();
		
	}
//
//	@Test
//	void testComplexFunctionString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testStringToOperation() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testF() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInitFromString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCopy() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testPlus() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testMul() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDiv() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testMax() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testMin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testComp() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLeft() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRight() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetOp() {
//		fail("Not yet implemented");
//	}

}
