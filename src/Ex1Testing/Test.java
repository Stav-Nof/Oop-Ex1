package Ex1Testing;

import Ex1.ComplexFunction;
import Ex1.Polynom;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Polynom p1 = new Polynom("x^2+x");
		Polynom p2 = new Polynom("2x^2+5x");
		ComplexFunction cf = new ComplexFunction("plus", p1,p2);
		
		System.out.println(cf.toString());
	}

}
