package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Polynom;

class ComplexFunctionTest {

	@Test
	void firstConstructor() {
		
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","x-2", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		
			
			ComplexFunction cf = new ComplexFunction("div",p1,p2);
			ComplexFunction cf1 = new ComplexFunction("div",p1,p2);
			ComplexFunction cf2 = new ComplexFunction("plus",new Polynom(s3[1]), p2 );
			
			
			assertEquals(cf.toString(),cf1.toString());
			assertFalse(cf.equals(cf2));
	}

//	@Test
//	void testComplexFunctionOperationFunctionFunction() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testComplexFunctionFunction() {
//		fail("Not yet implemented");
//	}
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
