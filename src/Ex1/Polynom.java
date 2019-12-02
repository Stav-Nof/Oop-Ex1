package Ex1;


import java.util.Iterator;
import java.util.LinkedList;

import Ex1.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	LinkedList<Monom> monoms;


	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		monoms = new LinkedList<Monom>();
	}


	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		if (this.monoms == null) {
			this.monoms = new LinkedList<Monom>();
		}
		String monom = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '+' && s.charAt(i) != '-' ) {
				monom = monom + s.charAt(i);
			}
			if (s.charAt(i) == '+') {
				if (!monom.equals("")) {
					Monom temp = new Monom (monom);
					this.add(temp);
				}
				monom = "";
			}
			if (s.charAt(i) == '-') {
				if (!monom.equals("")) {
					Monom temp = new Monom (monom);
					this.add(temp);
				}
				monom = "-";	
			}
		}
		Monom temp = new Monom (monom);
		this.add(temp);
	}


	/**
	 * Implements the f function of the interface "Polynom_able".
	 * This function of type y=f(x), where both y and x are real numbers.
	 */
	@Override
	public double f(double x) {
		double ans = 0;
		Iterator<Monom> iter = this.iteretor();
		while (iter.hasNext()) {
			Monom temp = iter.next();
			ans = ans + temp.f(x);
		}
		return ans;
	}


	/**
	 * Implements the add function of the interface "Polynom_able".
	 * This function adds a polynom to another given polynom. Actually, adding a Polynom to another one 
	 * is similar to adding a Polynom to a Monom, therefore, the function is using the add function (below) which aims 
	 * to add a Monom to a Polynom.
	 * 
	 */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> iterator = p1.iteretor();
		while (iterator.hasNext()) {
			this.add(iterator.next());
		}
	}


	/**
	 * Implements the add function of the interface "Polynom_able".
	 * This function adds a Monom to another given Polynom. 
	 * 
	 * 
	 */
	@Override
	public void add(Monom m1) {
		boolean flag = true; // check if we already added the monom (m1) to this Polynom
		if (this.monoms.isEmpty()) {
			this.monoms.add(m1);
			flag = false;
		}
		else {
			Iterator<Monom> iterator = this.iteretor();
			Monom temp;
			while (flag && iterator.hasNext()) {
				temp = iterator.next();
				if (temp.get_power() == m1.get_power()) { // if the power of the checked monom is equal to the power of m1 them add the two monoms.
					temp.add(m1);
					flag = false;
				}
				else if(temp.get_power() < m1.get_power()) { //checks if the power of m1 is greater the power of the checked monom. 
					Monom moveIn = temp;
					int index = this.monoms.indexOf(moveIn); // get the index of the current monom
					this.monoms.set(index, m1); 
					Monom moveOut;
					while (iterator.hasNext()) { //swaping monoms
						moveOut = iterator.next();
						index++;
						this.monoms.set(index, moveIn);
						moveIn = moveOut;
					}
					this.monoms.add(moveIn);
					flag = false;
				}
			}
		}
		if (flag) { //if the monom is not placed , then place it at the end.
			this.monoms.add(m1);
		}
	}


	/**
	 *  Implements the substract function of the interface "Polynom_able".
	 *  This function substracts a polynom from another given polynom.
	 *  Like the add function, this function is using the substract functions below which aims to 
	 *  substract a monom from a Polynom.
	 */
	@Override
	public void substract(Polynom_able p1) {
		if (this == p1) {
			this.monoms.clear();
			this.monoms.add(new Monom(0,0));
		}
		else {
			Iterator<Monom> iterator = p1.iteretor();
			while (iterator.hasNext()) {
				Monom temp = iterator.next();
				this.substract(temp);
			}
		}
	}


	/**
	 * Implements the substract function of the interface "Polynom_able".
	 * This function substracts a monom from a Polynom.
	 * 
	 * @param m1 is a Monom
	 */
	public void substract(Monom m1) { // Similar to the add function.
		if (!this.monoms.isEmpty()) {
			Iterator<Monom> iterator = this.iteretor();
			Monom temp;
			boolean flag = false;
			while (!flag && iterator.hasNext()) {
				temp = iterator.next();
				if (temp.get_power() == m1.get_power()) {
					temp.substract(m1);
					flag = true;
				}
				else if(temp.get_power() < m1.get_power()) {
					Monom moveIn = temp;
					int index = this.monoms.indexOf(moveIn);
					this.monoms.set(index, m1);
					Monom moveOut;
					while (iterator.hasNext()) {
						moveOut = iterator.next();
						index++;
						this.monoms.set(index, moveIn);
						moveIn = moveOut;
					}
					this.monoms.add(moveIn);
					flag = true;
				}
				if(temp.get_power() < m1.get_power()) { //checks if the power of m1 is greater the power of the checked monom. 
					Monom moveIn = temp;
					int index = this.monoms.indexOf(moveIn); // get the index of the current monom
					this.monoms.set(index, m1); 
					Monom moveOut;
					while (iterator.hasNext()) { //swaping monoms
						moveOut = iterator.next();
						index++;
						this.monoms.set(index, moveIn);
						moveIn = moveOut;
					}
					this.monoms.add(moveIn);
					flag = false;
				}
			}
		}
		else {
			m1.opposite();
			this.monoms.add(m1);
		}
	}


	/**
	 * Implements the multiply function of the interface "Polynom_able".
	 * This function multiplies a Polynom by another Polynom.
	 */
	@Override
	public void multiply(Polynom_able p1) { 
		Polynom p2 = (Polynom) this.copy();
		Iterator<Monom> p2iterator = p2.iteretor(); // creates two iterators, one runs through this, the other through p1
		Iterator<Monom> p1iterator = p1.iteretor();
		Monom p2Temp;
		Monom p1Temp;
		if(p1iterator.hasNext()) { // multiply the first monom of p1 by 'this' then save the result, than does the same operation on the second monom of p1 and so on. At the end, add all the results.
			p1Temp = p1iterator.next();
			this.multiply(p1Temp);
		}
		while(p1iterator.hasNext()) { 
			p1Temp = p1iterator.next();
			while(p2iterator.hasNext()) {
				p2Temp = p2iterator.next();
				Monom temp = new Monom(p2Temp.get_coefficient() * p1Temp.get_coefficient(),p2Temp.get_power() + p1Temp.get_power());
				this.add(temp);
			}
			p2iterator = p2.iteretor();
		}
	}


	/**
	 * Implements the equals function of the interface "Polynom_able".
	 * This functions is checking if two polynoms are equal or not and returns a boolean statement.
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> thisIterator = this.iteretor();
		Iterator<Monom> p1Iterator = p1.iteretor();
		Monom thisTemp;
		Monom p1Temp;
		do {
			if (!thisIterator.hasNext() && !p1Iterator.hasNext()) {
				return true;
			}
			if(thisIterator.hasNext() && !p1Iterator.hasNext()) {
				return false;
			}
			if(!thisIterator.hasNext() && p1Iterator.hasNext()) {
				return false;
			}
			thisTemp = thisIterator.next();
			p1Temp = p1Iterator.next();
			if(!thisTemp.equals(p1Temp)) {
				return false;
			}
		} while(thisIterator.hasNext() || p1Iterator.hasNext());
		return true;
	}


	/**
	 * Implements the isZero function of the interface "Polynom_able".
	 * This function is checking wether the Polynom is a Zero  Polynom.
	 */
	@Override
	public boolean isZero() {
		Iterator<Monom> iterator = this.iteretor();
		Monom temp;
		while(iterator.hasNext()) {
			temp = iterator.next();
			if (!temp.isZero()) {
				return false;
			}
		}
		return true;
	}


	/**
	 * Implements the root function of the interface "cont_function".
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps assuming
	 * (f(x0)*f(x1)<=0, returns f(x2) such that: (i) x0<=x2<=x2 && (ii) f(x2)<eps.
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		if(f(x0) * f(x1) <= 0) {
			double mid = (x0 + x1) / 2;
			if (f(x0) == 0) {
				return x0;
			}
			if (f(x1) == 0) {
				return x1;
			} 
			if (Math.abs(f(mid)) < eps) {
				return mid;
			}
			if (f(mid) < 0) {
				return root (mid, x1, eps);
			}
			if (f(mid) > 0) {
				return root (x0, mid, eps);
			}
		}
		throw new RuntimeException("f(x0)*f(x1)>0");
	}


	/**
	 * This method makes a deep copy of a given Polynom.
	 */
	@Override
	public Polynom_able copy() {
		Polynom newpolynom = new Polynom();
		Iterator<Monom> iterator = this.iteretor();
		Monom temp;
		while(iterator.hasNext()) {
			temp = iterator.next();
			Monom newMonom = new Monom(temp);
			newpolynom.add(newMonom);
		}
		return newpolynom;
	}


	/**
	 * Implements the derivative function of the interface "Polynom_able".
	 * Computes the derivative of a Polynom.
	 */
	@Override
	public Polynom_able derivative() {
		Iterator<Monom> iterator = this.monoms.iterator();
		Monom temp;
		Polynom ans = new Polynom();
		while(iterator.hasNext()) {
			temp = iterator.next();
			ans.add(temp.derivative());
		}
		return ans;
	}


	/**
	 * Implements the area of the interface "cont_function".
	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		double ans = 0;
		while(x0 < x1 && f(x0) > 0) {
			double y = this.f(x0);
			double temp = eps * y;
			temp = Math.abs(temp);
			ans = ans + temp;
			x0 = x0 + eps;
		}
		return ans;
	}


	/**
	 * This method builds an Iterator in order to traverse  a Polynom.
	 */
	@Override
	public Iterator<Monom> iteretor() {
		Iterator<Monom> newiterator = this.monoms.iterator();
		return newiterator;
	}


	/**
	 * * Implements the multiply function of the interface "Polynom_able".
	 * Multiply this Polynom by Monom m1
	 * @param m1
	 */
	@Override
	public void multiply(Monom m1) {
		Iterator<Monom> iterator = this.iteretor();
		Monom temp;
		while(iterator.hasNext()) {
			temp = iterator.next();
			temp.multipy(m1);
		}
	}


	/**
	 * This function traverses a Polynom and turns it into a String
	 */
	public String toString () {
		String ans = "";
		Iterator<Monom> iterator = this.iteretor();
		if(iterator.hasNext()) {
			ans = iterator.next().toString();
		}
		while (iterator.hasNext()) {
			String temp = iterator.next().toString();
			if(!temp.equals("0")) {
				ans = ans + "+" + temp;
			}
		}
		return ans;
	}


}