package Ex1;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import Ex1.StdDraw;;

public class Functions_GUI implements functions {
	private LinkedList<function> ComplexFunctions;
	
	
	@Override
	public int size() {
		return ComplexFunctions.size();
	}

	
	@Override
	public boolean isEmpty() {
		return ComplexFunctions.isEmpty();
	}

	
	@Override
	public boolean contains(Object o) {
		return ComplexFunctions.contains(o);
	}

	
	@Override
	public Iterator<function> iterator() {
		Iterator<function> iterator = this.ComplexFunctions.iterator();
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
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}
	

}
