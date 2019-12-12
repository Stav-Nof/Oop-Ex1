package Ex1;

public class ComplexFunction implements complex_function {
	function left;
	function right;
	Operation op;


	public ComplexFunction() {
		this.left = null;
		this.right = null;
		this.op = Operation.None;
	}


	public ComplexFunction(String s, function left, function right) {
		this.op = StringToOperation(s);
		this.left = left.copy();
		this.right = right.copy(); 
		if (this.left == null) {
			this.right = left;
			this.right = null;
		}
		if (this.right == null) {
			this.op = Operation.None;
		}
	}


	public ComplexFunction(Operation op, function left, function right) {
		this.op = op;
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
	public ComplexFunction(function f) {
		initFromString(f.toString());
	}


	public ComplexFunction(String s) {
		s = s.toLowerCase();
		if(s.isEmpty()) {
			return;
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
				break;
			}
			func2 = func2 + s.charAt(i);
		}
		if (!func1.isEmpty()) {
			if((func1.charAt(0) >= '0' && func1.charAt(0) <= '9') || func1.charAt(0) == 'x' || func1.charAt(0) == '-' || func1.charAt(0) == '+') {
				if(func1.charAt(0) == '+') {
					func1 = func1.substring(1);
				}
				this.left = new Polynom(func1);
			}
			else {
				this.left = new ComplexFunction(func1);
			}
		}
		else {
			this.left = null;
		}
		if (!func2.isEmpty()) {
			if((func2.charAt(0) >= '0' && func2.charAt(0) <= '9') || func2.charAt(0) == 'x' || func2.charAt(0) == '-' || func2.charAt(0) == '+') {
				if(func2.charAt(0) == '+') {
					func2 = func2.substring(1);
				}
				this.right = new Polynom(func2);
			}
			else {
				this.right = new ComplexFunction(func2);
			}
			this.op = StringToOperation(operation);
		}
	}


	public static Operation StringToOperation(String s) {
		s = s.toLowerCase();
		if (s.equals("plus") || s.equals("add")) {
			return  Operation.Plus;
		}
		else if (s.equals("times") || s.equals("mul")) {
			return Operation.Times;
		}
		else if (s.equals("div") || s.equals("divide")) {
			return Operation.Divid;
		}
		else if (s.equals("max")) {
			return Operation.Max;
		}
		else if (s.equals("min")) {
			return Operation.Min;
		}
		else if (s.equals("comp")) {
			return Operation.Comp;
		}
		return Operation.None;
	}


	@Override
	public double f(double x) {
		double l = 0;
		double r = 0;
		if (this.right != null) {
			r = right.f(x);
		}
		if (this.left != null) {
			l = left.f(x);
		}
		if(op == Operation.Plus) {
			return l+r;
		}
		if(op == Operation.Times) {
			return l*r;
		}
		if(op == Operation.Divid) {
			return l/r;
		}
		if(op == Operation.Max) {
			return Math.max(l, r);
		}
		if(op == Operation.Min) {
			return Math.min(l, r);
		}
		if(op == Operation.Comp) {
			return left.f(right.f(x));
		}
		return 0;
	}


	@Override
	public function initFromString(String s) {
		ComplexFunction ans = new ComplexFunction(s);
		return ans;
	}


	public String toString() {
		String ans = "";
		if (this.left != null && this.right != null) {
			ans =  this.op.toString() + "(" + this.left.toString() + "," + this.right.toString() + ")";
		}
		if (this.right == null) {
			ans = this.left.toString();
		}
		return ans;
	}


	@Override
	public function copy() {
		String temp = this.toString();
		ComplexFunction ans = new ComplexFunction(temp);
		return ans;
	}


	@Override
	public void plus(function f1) {
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Plus;
		this.right  = f1;
	}


	@Override
	public void mul(function f1) {
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Times;
		this.right  = f1;
	}


	@Override
	public void div(function f1) {
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Divid;
		this.right  = f1;
	}


	@Override
	public void max(function f1) {
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Max;
		this.right  = f1;
	}


	@Override
	public void min(function f1) {
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Min;
		this.right  = f1;
	}


	@Override
	public void comp(function f1) {
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Comp;
		this.right  = f1;
	}


	@Override
	public function left() {
		return this.left;
	}


	@Override
	public function right() {
		return this.right;
	}


	@Override
	public Operation getOp() {
		return op;
	}


	public boolean equals(ComplexFunction cf) {
		String s1 = this.toString();
		String s2 = cf.toString();
		return s1.equals(s2);
	}


	public boolean equalsIn(ComplexFunction cf, double start, double end,int steps) {
		double plus = (start - end) / steps;
		for (double i = start; i <= end; i = i + plus) {
			if (!(this.f(i) == cf.f(i))) {
				return false;
			}
		}
		return true;
	}
}