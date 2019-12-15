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

/**
 * This class implements the functions interface.
 * It contains all the methods to draw the functions based on the classes we built before.
 * The object "Functions_GUI" is composed by a LinkedList that contains functions and an array that contains colors.
 */
public class Functions_GUI implements functions {
	private LinkedList<function> Functions;


	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};


	/**
	 * Constructor that initializes an empty LinkedList.   
	 */

	public Functions_GUI() {
		Functions = new LinkedList<function>();
	}

	/**
	 * Constructor that adds a function to a LinkedList of type function.
	 * @param e
	 */
	public Functions_GUI(function e) {
		if (Functions == null) {
			Functions = new LinkedList<function>();
		}
		Functions.add(e);
	}

	/**
	 * Implements the size function from functions interface.
	 * Returns the size of the LinkedList.
	 */
	@Override
	public int size() {
		return Functions.size();
	}

	/**
	 * Implements the isEmpty function from functions interface.
	 * Returns true if the LinkedList is Empty, false if the LinkedList is contains elements.
	 */
	@Override
	public boolean isEmpty() {
		return Functions.isEmpty();
	}

	/**
	 * Implements the contains function from functions interface.
	 * Returns true if the LinkedList contains the specified object, returns false if not.
	 * @param o
	 */
	@Override
	public boolean contains(Object o) {
		return Functions.contains(o);
	}

	/**
	 * Implements the iterator function from functions interface.
	 * Initialize an iterator that aims to traverse through this collection.
	 */
	@Override
	public Iterator<function> iterator() {
		Iterator<function> iterator = this.Functions.iterator();
		return iterator;
	}

	/**
	 * Implements the toArray function from functions interface.
	 * Turns a collection into an Array of type function.
	 * Returns an array containing all of the elements of this collection.
	 */
	@Override
	public Object[] toArray() {
		return Functions.toArray();
	}

	/**
	 * Implements the toArray function from functions interface.
	 * Turns a collection into a given array of type function.
	 * Returns an array containing all of the elements of this collection.
	 * @param a
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return Functions.toArray(a);
	}

	/**
	 * This function is checking whether or not the collections contains the specified element.
	 * Returns true if it, false if it's not.
	 * @param e
	 */
	@Override
	public boolean add(function e) {
		return this.Functions.add(e);
	}

	/**
	 * This function is removing a single object from this collection.
	 * If the collection has changed after the process, the function returns true, if the collection 
	 * didn't change, the function returns false.
	 * @param o
	 */
	@Override
	public boolean remove(Object o) {
		return Functions.remove(o);
	}



	/**
	 * This function is checking if this Collection is containing all of the elements of the specified collection.
	 * By iterating on both of those collections the functions is comparing between the elements of those collections
	 * and is checking them one by one. If at least one element of one the collections is not included in the other, the function
	 * returns false.
	 * On the contrary, if this collections contains all of the objects of the specified collection, the function returns true. 
	 * @param c
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return Functions.containsAll(c);
	}

	/**
	 * This function adds all of the elements of the specified collection to this collection by using the 
	 * built-in function addAll from LinkedList.
	 * @param c
	 */
	@Override
	public boolean addAll(Collection<? extends function> c) {
		return this.Functions.addAll(c);
	}

	/**
	 * Remove all of the elements on this collections that are contained in the specified collection.
	 * The functions is running through the specified collection and by using the remove function above, 
	 * the function is checking objects one by one. If both of the collections have elements in common, the 
	 * remove function above will remove them one by one.
	 * Returns true if the two collections have no common elements, false if the collection did not change.
	 * @param c
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return Functions.removeAll(c);
	}


	/**
	 * Retains only the elements of this collection that are contained in the specified collection.
	 * Iterates on the collections and check if they have different elements. 
	 * The function is checking if the objects of this collection are equal to the elements of the specified collection.
	 * If one of them is not in the specified collection, the function will remove it from this collection by using the
	 * remove function above.
	 * @param c
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return Functions.retainAll(c);
	}

	/**
	 * This function clears all of the elements of this collection by using the clear function of LinkedList.
	 */
	@Override
	public void clear() {
		this.Functions.clear();
	}


	/**
	 * Compares between this Functions_GUI and another given Functions_GUI.
	 * Returns true or false.
	 * @param fg
	 * @return boolean
	 */
	public boolean equals(Functions_GUI fg) {
		if(this.toString().equals(fg.toString())) {
			return true;
		}
		return false;
	}

	/**
	 * Turns this collection into a String by using an Iterator that will traverse the collection.
	 * While the collection has another element, the function is creating a temporary function and turns it into a String 
	 * by using the toString function from the "function interface".
	 * @return ans
	 */
	public String toString() {
		String ans = "";
		Iterator iterator = this.iterator();
		while(iterator.hasNext()) {
			function temp = (function) iterator.next();
			ans = ans + "[" + temp.toString() + "]";
			if(iterator.hasNext()) {
				ans = ans + ", ";
			}
		}
		return ans;
	}

	/**
	 * Initialize a collection of function from a file.
	 * Using BufferReader class, the buffer is reading from a file and while the buffer is reading a String that is not null, 
	 * the buffer is turning the file into a String, and this String is sent to the ComplexFunction constructor to build the function.
	 * Throws an Exception if the function can't read the file.
	 * @param file
	 * @throws printstackTrace
	 */
	@Override
	public void initFromFile(String file) throws IOException {
		if (this.Functions == null) {
			Functions_GUI temp = new Functions_GUI();
			this.Functions = temp.Functions;
		}
		String line = "";
		function toAdd = null;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			while ((line = buffer.readLine()) != null) {
				int index = 0;
				int space = 0;
				while(index < line.length()) {
					if (line.charAt(index) == ' ') {
						space++;
					}
					if (space == 2) {
						index++;
						break;
					}
					index++;
				}
				line = line.substring(index);
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

	/**
	 * This function is creating an Iterator and runs through the the collection.
	 * By creating a StringBuilder , the function is adding Strings of different lengths and saves all of the characteristics of 
	 * the given collection.
	 * Finally the function is writing the Strings into a file.
	 * If the function can't write to this file, it throws an Exception.
	 * @param file
	 * @throws exception
	 * @return
	 */
	@Override
	public void saveToFile(String file) throws IOException {
		Iterator<function> iter = this.iterator();
		try {
			PrintWriter pw = new PrintWriter(new File(file));
			StringBuilder sb = new StringBuilder();
			while(iter.hasNext()) {
				function temp = iter.next();
				int index = Functions.indexOf(temp);
				sb.append(Colors[index%Colors.length].toString() + " ");
				sb.append("f(x)= ");
				sb.append(temp.toString());
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

/**
 * This function is drawing all the functions that are contained is this collection.
 * In this function, the Graphic Interface is created, the range for x and y and also the resolution are part 
 * of this creation.
 * To make the interface more interactive and precise we also use colors for each function that we draw.
 * An iterator traverses the collection and draws every function according to its standards.
 * @param width
 * @param height
 * @param rx
 * @param ry
 * @param resolution
 */
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
			function temp = iterator.next();
			int index = Functions.indexOf(temp);
			StdDraw.setPenColor(Colors[index%Colors.length]);
			for(double i = minX; i <= maxX; i = i + steps) {
				StdDraw.line(i, temp.f(i), i + steps, temp.f(i + steps));
			}
		}
	}

/**
 * This function is trying to draw a function by reading from a JSon File.
 * If it succeed, the data is transfered to the drawFunction just above. If not, the function will
 * throw an exception.
 * @param json_file
 */
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

/**
 * A inner-class that contains all the parameters in order to draw a Function. In fact, we need the height, the 
 * width and the resolution of our Window, where the function will be drawn and 
 * we also need a range of values for x and y.
 * 
 */
	class GUI_params{
		public int Width;
		public int Height;
		public int Resolution;
		public double []Range_X;
		public double []Range_Y;
	}
}