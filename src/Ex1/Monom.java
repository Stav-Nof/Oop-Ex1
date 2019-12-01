package Ex1;

import java.util.Comparator;
import java.util.StringTokenizer;


/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x) {    
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}
	// ****** add your code below *********


	/**
	 * This constructor receives a String and initialize a Monom
	 	by using StringTokenizer, the function turns the given String into
	 	coefficient and power separatly. If needed, the function returns a negative coefficient if the string contains
	 	a "-" at the very beginning of it.
	 * @throws Exception if the String is not valid or if the String is empty
	 * @param s is a string 
	 * @throws Exception if the power is negative
	 * 
	 */
	public Monom(String s) {
		if (s.isEmpty()) {
			throw new RuntimeException("string empty");
		}
		boolean hasx = false;
		boolean haspower = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') { //if the char is not a number 
				if (s.charAt(i) != '^' && s.charAt(i) != 'x' && s.charAt(i) != '.' && s.charAt(i) != '-') { // if the char is not '^','x','.' or '-'.
					throw new RuntimeException("undefined string");
				}
			}
			if (s.charAt(i) == '^') { // check if there is more than one '^'.
				if (haspower) {
					throw new RuntimeException("undefined string");
				}
				haspower = true;
			}
			if (s.charAt(i) == 'x') {// check if there is more than one 'x'.
				if (hasx) {
					throw new RuntimeException("undefined string");
				}
				hasx = true;
			}
			if (haspower) { // check if there is a power without x.
				if(!hasx) {
					throw new RuntimeException("undefined string");
				}
			}
		}
		if (s.charAt(0) == 'x' || s.charAt(0) == 'X') { // if the first char is a 'x' , adds a 1 as coefficient.
			s = "1" + s;
		}
		StringTokenizer tokenizer = new StringTokenizer(s);
		String coefficient = tokenizer.nextToken("xX^");
		boolean negative = false;
		if(coefficient.charAt(0) == '-') {
			if(coefficient.length() == 1) { // check the case of '-x','-x^2',...
				coefficient = "";
			}
			else {
				coefficient= coefficient.substring(1);
			}
			negative = true;
		}
		if (coefficient.isEmpty()){ // check the case of 'x','x^2',...
			coefficient = "1";
		}
		if (coefficient.contains(".")) {
			int endIndex = coefficient.indexOf(".") + 3;
			if (endIndex < coefficient.length())
				coefficient = coefficient.substring(0 , coefficient.indexOf(".") + 3);
		}
		double a;
		if (negative) { // handles the case where the coefficient is a negative number
			try {
				a = Double.parseDouble(coefficient);
				a = a * -1;
			} catch (Exception e) {
				throw new NumberFormatException("the string includes a char that is not a number");
			}
		}
		else {
			try{
				a = Double.parseDouble(coefficient);
			} catch (Exception e) {
				throw new NumberFormatException("the string includes a char that is not a number");
			}
		}

		String power = "";
		if (tokenizer.hasMoreTokens()) {
			power = tokenizer.nextToken("xX^");
		}
		if (power.isEmpty()) {
			if(s.contains("x") || s.contains("X")) {
				power = "1";
			}
			else {
				power = "0";
			}
		}
		if(power.contains("-")) { //handles the case where the power is a negative number
			throw new NumberFormatException("power cannot be a negative number");
		}
		if(power.contains(".")) { //handles the case where the power is a decimal number
			throw new NumberFormatException("power cannot be a double number");
		}
		int b = 0;
		try {
			b = Integer.parseInt(power);
		} catch (Exception e) {
			throw new NumberFormatException("the string includes a char that is not a number");
		}
		if(a == 0) { // handles the cases where the coefficient is 0.
			b = 0;
		}
		set_coefficient(a);
		set_power(b);
	}


	/**
	 * The function is adding a Monom to another given Monom by comparing the powers of the two monoms.
	 If they're equal then the function perfoms an addition between the two coeffecients.
	 * 
	 * @param m is a Monom 
	 */
	public void add(Monom m) {
		if (this.get_power() == m._power) {
			this.set_coefficient(m.get_coefficient() + this.get_coefficient());
		}
		if(this.get_coefficient() == 0) {
			this.set_coefficient(m.get_coefficient());
			this.set_power(m.get_power());
		}
	}


	/**
	 * The function is multiplying a Monom by another given Monom : straight forward we multiply between the two coefficients
	 and then adding the power of each monom.
	 * 
	 * @param d is a Monom
	 */
	public void multipy(Monom d) {
		this.set_coefficient(d._coefficient * this.get_coefficient());
		this.set_power(d.get_power() + this.get_power());
	}


	/**
	 * Turns a Monom into String composed by the symbols "x" and "^".
	 */
	public String toString() {		
		String ans = "";
		if(this.get_coefficient() == 0) {
			ans = "0";
		}
		else if(this.get_power() == 0) {
			ans = ans + this.get_coefficient();
		}
		else if(this.get_coefficient() == 1) {
			ans = "x^"+this.get_power();
		}
		else if(this.get_power() == 1 ) {
			ans = this.get_coefficient()+"x";
		}
		else {
			ans = this.get_coefficient()+"x^"+this.get_power();
		}
		return ans;
	}


	// you may (always) add other methods.


	/**
	 * This Function is used to check if two monoms are equal or not.
	 * @param m is a monom
	 * @return true if the two given monoms are equal, false if not.
	 */
	public boolean equals (Monom m) {
		if (this.get_coefficient() == 0 && m.get_coefficient() == 0) { // handles the case where both of the two monoms are zeros.
			return true;
		}
		if(this.get_coefficient() == m.get_coefficient()) { // compares coefficients
			if (this.get_power() == m.get_power()) { // compares powers
				return true;
			}
		}
		return false;
	}


	/**
	 * The function is subtracting a Monom from another given Monom by straight forward checking if 
	 the powers are equal and if they are the function is setting a new coeffecient by substracting the
	 coeffecients.
	 * @param m is a monom
	 */
	public void substract (Monom m) {
		if (this.get_power()  == m.get_power()) {
			this.set_coefficient(this.get_coefficient() - m.get_coefficient());	
		}
		if(this.get_coefficient() == 0) {
			this.set_coefficient(0 - m.get_coefficient());
			this.set_power(m.get_power());
		}
	}


	/**
	 * The function reverses the sign of a  monom.
	 */
	public void opposite() {
		if (get_coefficient() != 0) {
			this.set_coefficient(this.get_coefficient() * -1);
		}
	}


	//****** Private Methods and Data *******


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;


}