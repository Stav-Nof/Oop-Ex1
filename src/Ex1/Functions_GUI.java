package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CompletionException;

import com.google.gson.Gson;


import Ex1.StdDraw;

public class Functions_GUI implements functions {
	private LinkedList<function> Functions;
	public static Color[] Colors = {Color.blue, Color.cyan,
			Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};





	public Functions_GUI() {
		Functions = new LinkedList<function>();
	}


	public Functions_GUI(function e) {
		if (Functions == null) {
			Functions = new LinkedList<function>();
		}
		Functions.add(e);
	}


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
		return this.Functions.add(e);
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
		return this.Functions.addAll(c);
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
		this.Functions.clear();
	}


	@Override
	public void initFromFile(String file) throws IOException {
        String line = "";
        function toAdd = null;
        try {
        	BufferedReader buffer = new BufferedReader(new FileReader(file));
            while ((line = buffer.readLine()) != null) {
    			if((line.charAt(0) >= '0' && line.charAt(0) <= '9') || line.charAt(0) == 'x' || line.charAt(0) == '-' || line.charAt(0) == '+') {
    				toAdd = new Polynom(line);
    			}
    			else {
    				toAdd = new ComplexFunction(line);
    			}
    			this.add(toAdd);
            }

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.out.println("could not read file");
        }
	}


	@Override
	public void saveToFile(String file) throws IOException {
		Iterator<function> iter = this.iterator();
		try {
			PrintWriter pw = new PrintWriter(new File(file));
			StringBuilder sb = new StringBuilder();
			while(iter.hasNext()) {
				sb.append(iter.next().toString());
				sb.append("\n");
			}
			pw.write(sb.toString());
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}


	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		StdDraw.setCanvasSize(width, height);
		double minX = rx.get_min(), maxX = rx.get_max(),sizX = maxX - minX;
		double minY = ry.get_min(), maxY = ry.get_max(),sizY = maxY - minY;
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		//vertical lines
		int vertical = (int) minX;
		for (int i = 0; i <= sizX; i++) {
			StdDraw.line(vertical, minY, vertical, maxY);
			vertical = (int) (vertical + (sizX / sizX));
		}
		//horizontal  lines
		int horizontal = (int) minY;
		for (double i = 0; i <= sizY; i++) {
			StdDraw.line(minX, horizontal, maxX, horizontal);
			horizontal = (int) (horizontal + (sizY / sizY));
		}
		//x axis
		vertical = (int) minX;
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(minX,0, maxX, 0);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = 0; i <= sizX; i++) {
			StdDraw.text(vertical, -0.15, "" + vertical);
			vertical =  vertical + 1;
		}
		//y axis
		horizontal = (int) minY;
		StdDraw.line(0,minY, 0, maxY);
		for (int i = 0; i <= sizY; i++) {
			StdDraw.text(-0.15, horizontal, "" + horizontal);
			horizontal =  horizontal + 1;
		}
		//draw functions
		Iterator<function> iterator = this.iterator();
		double steps = sizX / resolution;
		while(iterator.hasNext()) {
			StdDraw.setPenColor(Colors[(int) (Math.random()*Colors.length)]);
			function temp = iterator.next();
			for(double i = minX; i <= maxX; i = i + steps) {
				StdDraw.line(i, temp.f(i), i + steps, temp.f(i + steps));
			}
		}
	}


	@Override
	public void drawFunctions(String json_file) {
		try {
			Gson gson = new Gson();
			FileReader reader = new FileReader(json_file);
			GUI_params gp = gson.fromJson(reader,GUI_params.class);
			Range rx = new Range(gp.Range_X[0], gp.Range_X[1]);
			Range ry = new Range(gp.Range_Y[0], gp.Range_Y[1]);
			this.drawFunctions(gp.Width, gp.Height, rx, ry, gp.Resolution);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	class GUI_params{
		public int Width;
		public int Height;
		public int Resolution;
		public double []Range_X;
		public double []Range_Y;
	}
}