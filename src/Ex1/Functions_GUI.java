package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

import Ex1.StdDraw;;

public class Functions_GUI implements functions {
	private LinkedList<function> Functions;


	@Override
	public int size() {
		return Functions.size();
	}


	@Override
	public boolean isEmpty() {
		return Functions.isEmpty();
	}


	@Override
	public boolean contains(Object o) {
		return Functions.contains(o);
	}


	@Override
	public Iterator<function> iterator() {
		Iterator<function> iterator = this.Functions.iterator();
		return iterator;
	}


	@Override
	public Object[] toArray() {
		function[] ans = new function[this.size()];
		this.toArray(ans);
		return ans;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length < this.size()) {
			throw new RuntimeException("The given array is to small");
		}
		int i = 0;
		Iterator<function> iterator = this.iterator();
		while(iterator.hasNext()) {
			ComplexFunction temp = (ComplexFunction) iterator.next().copy();
			a[i] = (T) temp;
		}
		return a;
	}


	@Override
	public boolean add(function e) {
		// TODO Auto-generated method stub

		Iterator<function> iterator = this.iterator();
		boolean flag = false;
		while(iterator.hasNext() && flag) {
			function it = iterator.next();
			if(e.equals(it)) {
				flag = false;
			}
			else  {
				flag  = true ;
				break;
			}
		}

		return flag;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub

		Iterator<function> iterator = this.iterator();
		boolean b = false;
		while(iterator.hasNext()) {
			function it = iterator.next();
			if (it.equals(o)) {
				this.Functions.remove(it);
				b = true;
			}
			if (b == true) {
				break;
			}

		}

		return b;

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub

		if(this.size() < c.size()) {
			return false;
		}

		Iterator<?> iterator = this.iterator();

		Iterator<?> iterator1 = c.iterator();

		boolean flag = false;
		for (int i = 0; i < this.size(); i++) {
			Object o = iterator.next();
			for (int j = 0; j < c.size(); j++) {
				Object o1 = iterator1.next();
				if(o1.equals(o)) {
					flag = true;
					i++;
					break;
				}

			}
		}
		return flag;
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// Don't touch i will finish at Sunday YAKAKOT
		// number of line segments to plot
		int n = 100;
		double maxY = 2.0, minY = -2.0;

		// the function y = sin(4x), sampled at n+1 points
		// between x = 0 and x = pi
		double[] x = new double[n+1];
		double[] y = new double[n+1];
		for (int i = 0; i <= n; i++) {
			x[i] = Math.PI * i / n;
			y[i] = Math.sin(4*x[i]);
		}		
		// rescale the coordinate system
		StdDraw.setXscale(0, Math.PI);
		StdDraw.setYscale(minY, maxY);

		// vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= n; i=i+10) {
			StdDraw.line(x[i], minY, x[i], maxY);
		}
		// horizontal  lines
		for (double i = minY; i <= maxY; i=i+0.5) {
			StdDraw.line(0, i, Math.PI, i);
		}
		// x axis		
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(0, y[n/2], Math.PI, y[n/2]);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = 0; i <= n; i=i+10) {
			StdDraw.text(x[i]-0.07, -0.07, Integer.toString(i-n/2));
		}
		// y axis	
		StdDraw.line(x[n/2], minY, x[n/2], maxY);
		for (double i = minY; i <= maxY; i=i+0.5) {
			StdDraw.text(x[n/2]-0.07, i+0.07, Double.toString(i));
		}

		// plot the approximation to the function
		for (int i = 0; i < n; i++) {
			StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
		}
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(x[n/2], 1);
	}

@Override
public void drawFunctions(String json_file) {
	// TODO Auto-generated method stub

}


}
