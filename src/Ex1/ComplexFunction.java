package Ex1;

public class ComplexFunction implements complex_function{
	function left;
	function right;
	Operation op;


	//	 banay qui recoit string 
	//	f1 right 
	//	f2 left
	//	if f2 == null none
	//	if f1 = null alors f2 rentre en right au lieu de left


	public ComplexFunction(String s, function left, function right) {

		Operation p;
		String op = "";
		for (int i = 0; i < s.length(); i++) {
			op = op +s.charAt(i);
		}
		if (op == "plus" || op  == "P") {
			p = Operation.Plus;
		}
		else if (op == "Times" || op == "mul") {
			p = Operation.Times;
		}
		else if (op == "div" || op == "Divide") {
			p = Operation.Divid;
		}
		else if (op == "Max" || op == "max") {
			p = Operation.Max;
		}
		else if (op == "min" || op == "Min") {
			p = Operation.Min;
		}
		else if (op == "comp" || op == "Comp") {
			p = Operation.Comp;
		}

		this.left = left;
		this.right = right; 

		if (this.right == null) {
			p = Operation.None;
		}
		if (this.left == null) {
			this.right = left;
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
			Polynom temp = new Polynom(s);
			return temp;
		}
		ComplexFunction f1;
		ComplexFunction f2;
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
