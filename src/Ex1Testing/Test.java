package Ex1Testing;

import Ex1.ComplexFunction;
import Ex1.Polynom;
import Ex1.function;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		function f1 = new Polynom("2x^2+5x");
		function f2 = new Polynom("2x^2+5x");
		
		ComplexFunction cf1 = new ComplexFunction("plus",f1,f2);
		System.out.println(cf1.toString());
		ComplexFunction temp = cf1;
		ComplexFunction cf2 = (ComplexFunction) temp.initFromString("plus(mul(plus(2x^2+5x,x^2+x),2x^4+54x^5),5x^3+6x^2)");
		System.out.println(cf2.toString());
		System.out.println(cf2.f(2));
	}

}
