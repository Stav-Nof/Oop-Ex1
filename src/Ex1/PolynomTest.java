package Ex1;

public class PolynomTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		System.out.println("**********************");

	}
	public static void test1() {
		System.out.println("******  Test1:  ******");
		Polynom p1 = new Polynom();
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		for (int i = 0 ; i  <monoms.length ; i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		double aa = p1.area(0, 1, 0.0001);
		p1.substract(p1);
		System.out.println(p1.toString());
		System.out.println(aa);

	}
	public static void test2() {
		System.out.println("******  Test2:  ******");
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"2", "-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		p1.add(p2);
		System.out.println("p1+p2: "+p1);
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: "+p1);
		String s1 = p1.toString();
		//Polynom_able pp1 = Polynom.parse(s1);
		//System.out.println("from string: "+pp1);
	}


	public static void test3() {//test for area and root.
		System.out.println("******  Test3:  ******");
		String[][] polynoms = {{"3x^2","-6x^3","9x","-2"},
				{"x","5x","0","-5"},
				{"4x^6", "-5x^5", "1"}};
		for (int i = 0; i < polynoms.length; i++) {
			Polynom p1 = new Polynom();
			for (int j = 0; j < polynoms[i].length; j++) {
				Monom temp = new Monom(polynoms[i][j]);
				p1.add(temp);
			}
			System.out.println(i + ") " + p1 + " area: " + p1.area(-1, 0, 0.0001) + " root: " + p1.root(0, 1, 0.0001));
		}
	}


	public static void test4() {//test for add and substract.
		System.out.println("******  Test4:  ******");
		String[][] polynoms = {{"3x^2","-6x^3","9x","-2"},
				{"x","5x","0","-5"}};
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		for (int i = 0; i < polynoms[0].length; i++) {
			Monom temp = new Monom(polynoms[0][i]);
			p1.add(temp);
		}		
		for (int i = 0; i < polynoms[1].length; i++) {
			Monom temp = new Monom(polynoms[1][i]);
			p2.add(temp);
		}
		Polynom add = new Polynom();
		Polynom substract = new Polynom();
		add = (Polynom) p1.copy();
		substract = (Polynom)p1.copy();
		add.add(p2);
		substract.substract(p2);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("add: " + add);
		System.out.println("substract: " + substract);
	}


	public static void test5() {//test for multiply.
		System.out.println("******  Test5:  ******");
		String[][] polynoms = {{"3x^2","-6x^3","9x","-2"},
				{"1x"}};
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		for (int i = 0; i < polynoms[0].length; i++) {
			Monom temp = new Monom(polynoms[0][i]);
			p1.add(temp);
		}		
		for (int i = 0; i < polynoms[1].length; i++) {
			Monom temp = new Monom(polynoms[1][i]);
			p2.add(temp);
		}
		Polynom multiply = new Polynom();
		multiply = (Polynom) p1.copy();
		multiply.multiply(p2);

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("multiply: " + multiply);

	}


	public static void test6() {//test for equals.
		System.out.println("******  Test6:  ******");
		String[][] polynoms = {{"3x^2","-6x^3","9x","-2"},
				{"x","5x","0","-5"}};
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		for (int i = 0; i < polynoms[0].length; i++) {
			Monom temp = new Monom(polynoms[0][i]);
			p1.add(temp);
		}		
		for (int i = 0; i < polynoms[1].length; i++) {
			Monom temp = new Monom(polynoms[1][i]);
			p2.add(temp);
		}
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println(p1.equals(p2));
	}
}
