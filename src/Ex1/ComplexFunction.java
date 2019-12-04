package Ex1;

public class ComplexFunction implements complex_function{
	function left;
	function right;
	Operation op;


	public ComplexFunction(String s, function left, function right) {
		String operation = "";
		for (int i = 0; i < s.length(); i++) {
			operation = operation +s.charAt(i);
		}
		if (operation.equals("Plus") || operation.equals("plus")) {
			this.op =  Operation.Plus;
		}
		else if (operation.equals("Times") || operation.equals("mul")) {
			this.op = Operation.Times;
		}
		else if (operation.equals("div") || operation.equals("Divide")) {
			this.op = Operation.Divid;
		}
		else if (operation.equals("Max") || operation.equals("max")) {
			this.op = Operation.Max;
		}
		else if (operation.equals("min") || operation.equals("Min")) {
			this.op = Operation.Min;
		}
		else if (operation.equals("comp") || operation.equals("Comp")) {
			this.op = Operation.Comp;
		}
		this.left = left;
		this.right = right; 
		if (this.left == null) {
			this.right = left;
			this.right = null;
		}
		if (this.right == null) {
			this.op = Operation.None;
		}
	}



	@Override
	public double f(double x) {
		double l = left.f(x);
		double r = right.f(x);
		if(op == op.Plus) {
			return l+r;
		}
		if(op == op.Times) {
			return l*r;
		}
		if(op == op.Divid) {
			return l/r;
		}
		if(op == op.Max) {
			return Math.max(l, r);
		}
		if(op == op.Min) {
			return Math.min(l, r);
		}
		if(op == op.Comp) {
			return left.f(right.f(x));
		}
		return 0;
	}

	@Override
	public function initFromString(String s) {
		if(!(s.charAt(0) == 'P') || !(s.charAt(0) == 'p')|| !(s.charAt(0) == 'T') || !(s.charAt(0) == 't')|| !(s.charAt(0) == 'M') || !(s.charAt(0) == 'm')|| !(s.charAt(0) == 'D') || !(s.charAt(0) == 'd')|| !(s.charAt(0) == 'M') || !(s.charAt(0) == 'm')|| !(s.charAt(0) == 'C') || !(s.charAt(0) == 'c')) {
			function temp = new Polynom(s);
			return temp;
		}
		String operation = "";
		int counter = 0;
		int i = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) != '(') {
				operation = operation + s.charAt(i);
			}
			else {
				counter++;
				i++;
				break;
			}
		}
		String func1 = "";
		for (; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				counter++;
			}
			if (s.charAt(i) == ')') {
				counter--;
			}
			if(s.charAt(i) == ',' && counter == 1) {
				i++;
				break;
			}
			func1 = func1 + s.charAt(i);
		}
		String func2 = "";
		for (; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				counter++;
			}
			if (s.charAt(i) == ')') {
				counter--;
			}
			if(s.charAt(i) == ')' && counter == 0) {
				i++;
				break;
			}
			func2 = func2 + s.charAt(i);
		}
		ComplexFunction ans = new ComplexFunction(operation, initFromString(func1), initFromString(func2));
		return ans;
	}


	public String toString() {
		String ans = this.left.toString() + this.op + this.right.toString();
		return ans;
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub










		return null;
	}

	@Override
	public void plus(function f1) {
		// TODO Auto-generated method stub
		this.op = Operation.Plus;
		this.right  = f1;
	}


	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		this.op = Operation.Times;
		this.right = f1;
	}


	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		this.op = Operation.Divid;
		this.right = f1;
	}


	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		this.op = Operation.Max;
		this.right = f1;
	}


	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		this.op = Operation.Min;
		this.right = f1;
	}


	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		this.op = Operation.Comp;
		this.right = f1;
	}


	@Override
	public function left() {
		// TODO Auto-generated method stub
		return this.left;
	}


	@Override
	public function right() {
		// TODO Auto-generated method stub
		return this.right;
	}


	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}

}
