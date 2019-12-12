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
	void constructors() {



	}


	@Test
	void constructorfirstTest() {
		ComplexFunction t1 = new ComplexFunction();
		assertEquals(t1.toString(), "");

		Polynom p1 = new Polynom("3.1+2.4x^2-x^4");
		Polynom p2 = new Polynom("5+2x-3.3x+0.1x^5");
		Monom m1 = new Monom("-x");

		ComplexFunction cf = new ComplexFunction("div",p1,p2);
		ComplexFunction cf1 = new ComplexFunction("div",p1,p2);
		ComplexFunction cf2 = new ComplexFunction("div(mul(2x^2,3x^2-5x+2),-x)");
		ComplexFunction cf3 = new ComplexFunction("mul(2x^2,3x^2-5x+2)");
		ComplexFunction cf4 = new ComplexFunction("div", cf3, m1 );
		ComplexFunction cf5 = new ComplexFunction("div(mul(2x,3x^2-5x+2),-x");
		ComplexFunction cf6 = new ComplexFunction("div(3.1+2.4x^2-x^4,5+2x-3.3x+0.1x^5)");

		assertTrue(cf.equals(cf1));
		assertTrue(cf4.equals(cf2));
		assertNotEquals(cf2.toString(),cf5.toString());
		assertEquals(cf6.toString(), cf.toString());
	}


	@Test
	void constructorSecondTest() {
		String s1 = "2x^2-5x+1";
		Monom m = new Monom("4x^2");
		Monom m1 = new Monom("-2x");
		Monom m2 = new Monom("4x^5");
		Monom m3 = new Monom("-2x^4");
		Polynom p1 = new Polynom("2x^2+5x");

		ComplexFunction cf = new ComplexFunction(Operation.Divid,m,m1);
		ComplexFunction cf1 = new ComplexFunction(Operation.Divid,m2,m3);
		ComplexFunction cf2 = new ComplexFunction(Operation.Max, new Polynom("2x^2-5x+1"), p1);
		ComplexFunction cf3 = new ComplexFunction("max", new Polynom(s1), p1 );
		ComplexFunction cf4 = new ComplexFunction("div", new Polynom("5+2x-3.3x+0.1x^5"), m1 );
		ComplexFunction cf5 = new ComplexFunction("div", new Polynom("5+2x-3.3x+0.1x^5"), new Monom("-2x") );

		assertFalse(cf.equals(cf1));
		assertTrue(cf2.equals(cf3));
		assertEquals(cf2.toString(), cf3.toString());
		assertTrue(cf4.equals(cf5));
	}


	@Test
	void constructorThirdTest() {
		Monom m = new Monom("4x^2");
		Monom m1 = new Monom("-2x");
		ComplexFunction cf = new ComplexFunction(Operation.Divid,m,m1);
		ComplexFunction cf1 = new ComplexFunction("mul(plus(3x^2+9x^4+6x^5,10x-5x^2),-6x^6+7x^2)");
		ComplexFunction cf2 = new ComplexFunction(Operation.Plus, new Polynom ("3x^2+9x^4+6x^5"), new Polynom("10x-5x^2"));
		ComplexFunction cf3 = new ComplexFunction(Operation.Times , cf2 , new Polynom("-6x^6+7x^2"));
		ComplexFunction f = (ComplexFunction) cf.initFromString(cf3.toString());
		assertEquals(cf1.toString(), f.toString());
		assertTrue(cf1.equals(f));
	}


	@Test
	void testF() {
		//Plus
		ComplexFunction cf1 = new ComplexFunction(Operation.Plus, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		assertEquals(40,cf1.f(-5));
		assertEquals(0,cf1.f(-1));
		assertEquals(0,cf1.f(0));
		assertEquals(4,cf1.f(1));
		assertEquals(60,cf1.f(5));
		//Times
		ComplexFunction cf2 = new ComplexFunction(Operation.Times, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		assertEquals(-25200,cf2.f(-5));
		assertEquals(-64,cf2.f(-1));
		assertEquals(0,cf2.f(0));
		assertEquals(-12,cf2.f(1));
		assertEquals(-18700,cf2.f(5));
		//Divid
		ComplexFunction cf3 = new ComplexFunction(Operation.Divid, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		assertEquals(-0.7777777777777778,cf3.f(-5));
		assertEquals(-1.0,cf3.f(-1));
		//assertEquals(0,cf3.f(0));//undefined
		assertEquals(-1.0/3.0,cf3.f(1));
		assertEquals(-0.6470588235294118,cf3.f(5));
		//Max
		ComplexFunction cf4 = new ComplexFunction(Operation.Max, new Polynom ("7x^2-5"), new Polynom("x"));
		assertEquals(170,cf4.f(-5));
		assertEquals(2,cf4.f(-1));
		assertEquals(0,cf4.f(0));
		assertEquals(2.,cf4.f(1));
		assertEquals(170,cf4.f(5));
		//Min
		ComplexFunction cf5 = new ComplexFunction(Operation.Min, new Polynom ("7x^2-5"), new Polynom("x"));
		assertEquals(-5,cf5.f(-5));
		assertEquals(-1,cf5.f(-1));
		assertEquals(-5,cf5.f(0));
		assertEquals(1.,cf5.f(1));
		assertEquals(5,cf5.f(5));
		//Comp
		ComplexFunction cf6 = new ComplexFunction(Operation.Comp, new Polynom ("-5x^2+3x"), new Polynom("7x^2-x"));
		assertEquals(-161460,cf6.f(-5));
		assertEquals(-296,cf6.f(-1));
		assertEquals(0,cf6.f(0));
		assertEquals(-162,cf6.f(1));
		assertEquals(-143990,cf6.f(5));
	}


	@Test
	void testCopy() {
		ComplexFunction cf1 = new ComplexFunction("div(mul(2x^2,3x^2-5x+2),-x)");
		ComplexFunction cf2 = (ComplexFunction) cf1.copy();
		assertEquals(cf1.toString(),cf2.toString());
	}


	void testPplus() {
		String s = "3x^2-10x+2";
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2-5x+2)");
		function f1 = cf1.initFromString(s);
		cf1.mul(f1);
		ComplexFunction cf = new ComplexFunction(Operation.Times, new ComplexFunction("plus(2x^2,3x^2-5x+2)"), new Polynom("3x^2-10x+2"));
		assertTrue(cf1.equals(cf));
		assertEquals(cf1.toString(), cf.toString());
	}


	@Test
	void testMul() {
		String s ="3x^2-10x+2";
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2-5x+2)");
		function f1 = cf1.initFromString(s);
		cf1.mul(f1);
		ComplexFunction cf = new ComplexFunction(Operation.Times, new ComplexFunction("plus(2x^2,3x^2-5x+2)"), new Polynom("3x^2-10x+2"));
		assertTrue(cf1.equals(cf));
		assertEquals(cf1.toString(), cf.toString());
	}


	@Test
	void testDiv() {
		String s = "x^2+3x-5";
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2-2x,3x^2)");
		function f1 = cf1.initFromString(s);
		cf1.div(f1);
		ComplexFunction cf = new ComplexFunction(Operation.Divid, new ComplexFunction("plus(2x^2-2x,3x^2"), new Polynom("x^2+3x-5"));
		assertTrue(cf1.equals(cf));
		assertEquals(cf1.toString(), cf.toString());
	}


	@Test
	void testMax() {
		String s ="-x^2";
		ComplexFunction cf1 = new ComplexFunction("div(2x^2,3x^2)");
		function f1 = cf1.initFromString(s);
		cf1.max(f1);
		ComplexFunction cf = new ComplexFunction(Operation.Max, new ComplexFunction("div(2x^2,3x^2)"), new Monom("-x^2"));
		assertTrue(cf1.equals(cf));
		assertEquals(cf1.toString(), cf.toString());
	}


	@Test
	void testMin() {

		String s ="-x^2";
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2)");
		function f1 = cf1.initFromString(s);
		cf1.min(f1);
		ComplexFunction cf = new ComplexFunction(Operation.Min, new ComplexFunction("plus(2x^2,3x^2"), new Monom("-x^2"));
		assertTrue(cf1.equals(cf));
		assertEquals(cf1.toString(), cf.toString());
	}


	@Test
	void testComp() {
		String s ="-x^2";
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2)");
		function f1 = cf1.initFromString(s);
		cf1.comp(f1);
		ComplexFunction cf = new ComplexFunction(Operation.Comp, new ComplexFunction("plus(2x^2,3x^2"), new Monom("-x^2"));
		assertTrue(cf1.equals(cf));
		assertEquals(cf1.toString(), cf.toString());
	}


	@Test
	void testLeft() {
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2)");
		assertEquals(new Monom("2x^2").toString(), cf1.left().toString());
	}

	@Test
	void testRight() {
		ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2)");
		assertEquals(new Monom("3x^2").toString(), cf1.right().toString());
	}
	
		@Test
		void testGetOp() {
			ComplexFunction cf1 = new ComplexFunction("plus(2x^2,3x^2)");
			assertEquals(Operation.Plus.toString(), cf1.getOp().toString());
		}
		
		
		@Test
		void testEqualsIn() {
			ComplexFunction cf1 = new ComplexFunction("mul(x,x)");
			ComplexFunction cf2 = new ComplexFunction("plus(x^2,0)");
			assertTrue(cf1.equalsIn(cf2, -10, 10, 20));
			ComplexFunction cf3 = new ComplexFunction("mul(x^2,x)");
			ComplexFunction cf4 = new ComplexFunction("plus(x^2,0)");
			assertFalse(cf3.equalsIn(cf4, -10, 10, 20));
		}
}
