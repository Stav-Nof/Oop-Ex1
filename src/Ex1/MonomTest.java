package Ex1;
import java.util.ArrayList;
/**
 * This class represents a simple (naive) tester for the Monom class, 
 * Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and functionality of the Monom class.  <br>
 * (iii) Expected output:  <br>
 * *****  Test1:  *****  <br>
0) 2.0    	isZero: false	 f(0) = 2.0  <br>
1) -1.0x    	isZero: false	 f(1) = -1.0  <br>
2) -3.2x^2    	isZero: false	 f(2) = -12.8  <br>
3) 0    	isZero: true	 f(3) = 0.0  <br>
 *****  Test2:  *****  <br>
0) 0    	isZero: true  	eq: true  <br>
1) -1.0    	isZero: false  	eq: true  <br>
2) -1.3x    	isZero: false  	eq: true  <br>
3) -2.2x^2    	isZero: false  	eq: true  <br>
 */
public class MonomTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		System.out.println("********************");
	}
	private static void test1() {
		System.out.println("*****  Test1:  *****");
		String[] monoms = {"3x^2","0.5","2^2","x","-2","-x","2x^0","0x^2","","(2x^5)","2sdx^3","2x^3a","1x","1x^1","3x^-5","-5x^3","3^3x^3","3+3x^2","2^3+3","1234x^1234","x^x","3x^","2-2x^2"};
		for(int i=0;i<monoms.length;i++) {
			try {
				Monom m = new Monom(monoms[i]);
				String s = m.toString();
				m = new Monom(s);
				double fx = m.f(i);
				System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx+"     " + monoms[i]);
			}
			catch (Exception e) {
				System.out.println(i+") " + e.getLocalizedMessage()+", String: " + monoms[i]);
			}
		}
	}


	private static void test2() {
		System.out.println("*****  Test2:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		try{
			monoms.add(new Monom(0,5));
			monoms.add(new Monom(-1,0));
			monoms.add(new Monom(-1.3,1));
			monoms.add(new Monom(-2.2,2));
			monoms.add(new Monom(-560.3,14));
			monoms.add(new Monom(0,0));
			monoms.add(new Monom(-1,2));
			monoms.add(new Monom(-2,0));
			monoms.add(new Monom(-0,0));
			monoms.add(new Monom(0,2));
			monoms.add(new Monom(-3,450));
			monoms.add(new Monom(0,0));
			monoms.add(new Monom(1,-1));
			monoms.add(new Monom(1234,1234));
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		for(int i=0;i<monoms.size();i++) {
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.equals(m1);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
		}
	}

	private static void test3() {	//test for add, multipy and substract.
		System.out.println("*****  Test3:  *****");
		String[] monoms = {"2x", "-x","-3.2x^2","0","1x","0x","2.0x^4","0.5"};
		for(int i=0;i<monoms.length-1;i++) {
			Monom one = new Monom(monoms[i]);
			Monom two = new Monom(monoms[i+1]);
			one.add(two);
			Monom add = new Monom(one);
			one = new Monom(monoms[i]);
			one.multipy(two);
			Monom multiply = new Monom(one);
			one = new Monom(monoms[i]);
			one.substract(two);
			Monom substract = new Monom(one);
			one = new Monom(monoms[i]);
			System.out.println(i+") monom1: " + one + " monom2: " + two + "   add: " + add + "   multiply: " + multiply + " substract: " + substract);



		}


	}

}
