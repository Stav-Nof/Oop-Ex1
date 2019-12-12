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
			ComplexFunction cf7 = new ComplexFunction("div(3.1+2.4x^2-x^4,5+2x-3.3x+0.1x^5)");
			
			assertTrue(cf.equals(cf1));
			assertTrue(cf5.equals(cf3));
			assertNotEquals(cf3.toString(),cf6.toString());
			assertEquals(cf7.toString(), cf.toString());
			
		
			

		
			
	}

	@Test
	void secondConstructor() {
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","2x^2-5x+1", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p5 = new Polynom("-3x^2+2x^3");
		Monom m = new Monom("4x^2");
		Monom m1 = new Monom("-2x");
		Monom m2 = new Monom("4x^5");
		Monom m3 = new Monom("-2x^4");
		Polynom p3 = new Polynom("3x^2-5x+2");
		Polynom p4 = new Polynom("2x^2+5x");
		
		
		
			ComplexFunction cf = new ComplexFunction(Operation.Divid,m,m1);
			
			ComplexFunction cf1 = new ComplexFunction(Operation.Divid,m2,m3);
			
			ComplexFunction cf2 = new ComplexFunction(Operation.Times,new Polynom(s3[1]), p4);
			ComplexFunction cf3 = new ComplexFunction(Operation.Max, new Polynom("2x^2-5x+1"), p4);
			
			ComplexFunction cf4 = new ComplexFunction("max", new Polynom(s3[1]), p4 );
			ComplexFunction cf5 = new ComplexFunction("div", new Polynom("5+2x-3.3x+0.1x^5"), m1 );
			ComplexFunction cf6 = new ComplexFunction(Operation.Divid , p2, p3);
			ComplexFunction cf7 = new ComplexFunction("div", new Polynom("5+2x-3.3x+0.1x^5"), new Monom("-x") );
			
		assertFalse(cf.equals(cf1));
		assertTrue(cf3.equals(cf4));
		assertEquals(cf3.toString(), cf4.toString());
		assertTrue(cf5.equals(cf7));
		
		
		
		
		
		
		
		
		
		
		
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
			ComplexFunction cf1 = new ComplexFunction(Operation.Plus,m2,m3);
			ComplexFunction cf2 = new ComplexFunction(Operation.Times,new Polynom(s3[1]), p2);
			ComplexFunction cf3 = new ComplexFunction(Operation.Max, new Polynom(s3[0]), p4);
			ComplexFunction cf4 = new ComplexFunction("mul(plus(3x^2+9x^4+6x^5,10x-5x^2),-6x^6+7x^2)");
			ComplexFunction cf5 = new ComplexFunction(Operation.Plus, new Polynom ("3x^2+9x^4+6x^5"), new Polynom("10x-5x^2"));
			ComplexFunction cf7 = new ComplexFunction(Operation.Times , cf5 , new Polynom("-6x^6+7x^2"));
			ComplexFunction cf6 = new ComplexFunction("div", cf4, m1 );
			
			ComplexFunction f = (ComplexFunction) cf.initFromString(cf7.toString());
			assertEquals(cf4.toString(), f.toString());
			assertTrue(cf4.equals(f));
		
			
			
			
			
		
	}

	

	@Test
	void testStringToOperation() {
		
		String s  = "plus";
		String s1 = "mul";
		String s2 = "max";
		String s3 = "Min";
		String s4 = "Comp";
		String s5 = "Divide";
		String s6 = "weojiwen";
		
		Operation op = Operation.Plus;
		Operation op1 = Operation.Times;
		Operation op2= Operation.Max;
		Operation op3 = Operation.Min;
		Operation op4 = Operation.Comp;
		Operation op5 = Operation.Divid;
		Operation op6 = Operation.None;
		
		assertEquals(s,op.toString());
		assertEquals(s1,op1.toString());
		assertEquals(s2,op2.toString());
		assertEquals(s3,op3.toString());
		assertEquals(s4,op4.toString());
		assertEquals(s5,op5.toString());
		assertEquals(s6,op6.toString());
	
		
	}

	@Test
	void testF() {
	
		double exp = -12;
		double exp2 = -1/3;
		double exp3 = 690;
		ComplexFunction cf5 = new ComplexFunction(Operation.Times, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		ComplexFunction cf6 = new ComplexFunction(Operation.Divid, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		ComplexFunction cf7 = new ComplexFunction(Operation.Max, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		double actual = cf5.f(1);
		double actual2 = cf6.f(1);
		double actual3 = cf7.f(10);
		assertEquals(exp,actual);
		
		
	}


	@Test
	void testCopy() {
		
		ComplexFunction cf3 = new ComplexFunction("div(mul(2x^2,3x^2-5x+2),-x)");
		ComplexFunction cf4 = (ComplexFunction) cf3.copy();
		assertEquals(cf3.toString(),cf4.toString());
		
		
	}

	@Test
	void testPlus() {

		String s = "x^2+3x-5";
		String s2 ="3x^2-10x+2";
		ComplexFunction cf3 = new ComplexFunction("plus(2x^2,3x^2-5x+2)");
		function f = cf3.initFromString(s);
		function f1 = cf3.initFromString(s2);
		cf3.plus(f1);
		
		Polynom exp = new Polynom ("8x^2-15x+4");
		function f2 = (function)exp;
		assertEquals(cf3.toString(),exp.toString());
		assertTrue(cf3.equals(f2));
		
		
		
		
	}

	@Test
	void testMul() {
		
		String s = "x^2+3x-5";
		String s2 ="3x^2-10x+2";
		ComplexFunction cf3 = new ComplexFunction("plus(2x^2,3x^2-5x+2)");
		
		function f1 = cf3.initFromString(s2);
		cf3.mul(f1);
		
		Polynom exp = new Polynom ("15x^4-65x^3+16x^2-30x+4");
		function f2 = (function)exp;
		assertEquals(cf3.toString(),exp.toString());
		assertTrue(cf3.equals(f2));
		
		
		
	}

	@Test
	void testDiv() {
	
		
		String s = "x^2+3x-5";
		String s2 ="-x^2";
		ComplexFunction cf3 = new ComplexFunction("plus(2x^2,3x^2)");
		
		function f1 = cf3.initFromString(s2);
		cf3.div(f1);
		
		Monom exp = new Monom ("-5");
		function f2 = (function)exp;
		assertEquals(cf3.toString(),exp.toString());
		assertTrue(cf3.equals(f2));
		
		
		
	}

	@Test
	void testMax() {
		
		String s = "x^2+3x-5";
		String s2 ="-x^2";
		ComplexFunction cf3 = new ComplexFunction("plus(2x^2,3x^2)");
		
		function f1 = cf3.initFromString(s2);
		cf3.max(f1);
		
		Monom exp = new Monom ("5x^2");
		function f2 = (function)exp;
		assertEquals(cf3.toString(),exp.toString());
		assertTrue(cf3.equals(f2));
	}

	@Test
	void testMin() {
		String s = "x^2+3x-5";
		String s2 ="-x^2";
		ComplexFunction cf3 = new ComplexFunction("plus(2x^2,3x^2)");
		
		function f1 = cf3.initFromString(s2);
		cf3.min(f1);
		
		Monom exp = new Monom ("-x^2");
		function f2 = (function)exp;
		assertEquals(cf3.toString(),exp.toString());
		assertTrue(cf3.equals(f2));
	}

	@Test
	void testComp() {
		fail("Not yet implemented");
	}

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
