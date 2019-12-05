package Ex1Testing;

import Ex1.ComplexFunction;
import Ex1.Polynom;
import Ex1.function;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		function f1 = new Polynom("2x^2+5x");
		function f2 = new Polynom("2x^2+5x");
		
		ComplexFunction cf1 = new ComplexFunction("plus(mul(plus(2x^2-5x,2x^2-5x),2x^2+5x),2x^2+5x)");
		System.out.println(cf1.f(3));
		ComplexFunction cf2 = (ComplexFunction) cf1.copy();
		System.out.println(cf1.toString());
		System.out.println(cf2.toString());
	}
	
	

}
