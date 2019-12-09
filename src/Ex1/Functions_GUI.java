package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.gson.Gson;

import Ex1.StdDraw;

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
		Iterator<function> iterator = this.iterator();
		while(iterator.hasNext()) {
			function it = iterator.next();
			if(e.equals(it)) {
				return false;
			}
		}
		this.Functions.add(e);
		return true;
	}


	@Override
	public boolean remove(Object o) {
		Iterator<function> iterator = this.iterator();
		while(iterator.hasNext()) {
			function thiso = iterator.next();
			if (thiso.equals(o)) {
				this.Functions.remove(thiso);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(this.size() < c.size()) {
			return false;
		}
		Iterator<function> thisIterator = this.iterator();
		Iterator<?> cIterator = c.iterator();
		while(cIterator.hasNext()) {
			boolean flag = false;
			Object co = cIterator.next();
			while(thisIterator.hasNext()) {
				Object thiso = thisIterator.next();
				if(co.equals(thiso)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}


	@Override
	public boolean addAll(Collection<? extends function> c) {
		// TODO
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean flag = false;
		Iterator<?> cIterator = c.iterator();
		while(cIterator.hasNext()) {
			function cFunction = (function) cIterator.next();
			boolean temp = this.remove(cFunction);
			if (temp) {
				flag = true;
			}
		}
		return flag;
	}
	

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean flag = false;
		Iterator<function> thisIterator = this.iterator();
		while (thisIterator.hasNext()) {
			function thisFunction = thisIterator.next();
			Iterator<?> cIterator = c.iterator();
			boolean inC = false;
			while(cIterator.hasNext()) {
				function cFunction = (function) cIterator.next();
				if(thisFunction.equals(cFunction)) {
					inC = true;
					break;
				}
			}
			if (inC) {
				this.remove(thisFunction);
				flag = true;
			}
		}
		return flag;
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.Functions.clear();

	}

	@Override
	public void initFromFile(String file) throws IOException {
		Gson gson = new Gson();
		try {
			FileReader reader = new FileReader(file);
			Functions_GUI func = gson.fromJson(reader,Functions_GUI.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void saveToFile(String file) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		try {
			PrintWriter pw = new PrintWriter(new File(file));
			pw.write(json);
			pw.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
	Iterator<function> iterator =this.iterator();
	
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
		//width
		StdDraw.setXscale(0, Math.PI);
		//height
		StdDraw.setYscale(minY, maxY);

		// vertical lines 'Range ry'
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= n; i=i+10) {
			StdDraw.line(x[i], minY, x[i], maxY);
		}
		// horizontal  lines 'Range rx'
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
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
	}

}