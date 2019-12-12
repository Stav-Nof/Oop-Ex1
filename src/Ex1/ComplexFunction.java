package Ex1;

/*
 * Implementation of comple_function interface.
 * This class contains all the methods in order to build a ComplexFunction.
 * First, the class get two pointers, one for the left side and one for the right side of the function.
 * Those pointers are of the type "function".
 * The class is getting an operation of type "Operation". Indeed, we need to perform an operation(or more) between the function(s) on the left and the right side.
 * Those operations are defined in the Operation class which is a enum class.
 */
public class ComplexFunction implements complex_function {
	function left;
	function right;
	Operation op;

	/*
	 * Constructs an empty ComplexFunction
	 */
	public ComplexFunction() {
		this.left = null;
		this.right = null;
		this.op = Operation.None;
	}

	/*
	 * Constructs a ComplexFunction by receiving a String(which is the operation), a function on its left and right side.
	 */
	public ComplexFunction(String s, function left, function right) {
		s = s.toLowerCase();
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

	/*
	 * Constructs a ComplexFunction from our enum class (Operation), a function on it's left ans right side.
	 */
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
	/*
	 * Constructs a ComplexFunction from a given function,simply by turning the
	 *  function into a String and then initialize the ComplexFunction by sending this String to "initFromString" function.
	 */
	public ComplexFunction(function f) {
		initFromString(f.toString());
	}

	/*
	 * Constructs a ComplexFunction from a String only. This String is containing an operation (or several) and a function on 
	 * each side (or severals). This Constructor is separating between the elements and aims to differentiates between the characters in order to 
	 * get the informations we want to create a real ComplexFunction.
	 * The constructor is using recursion.
	 */
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

	/*
	 * This function is used by the second, the fourth and the fifth Constructor (above). 
	 * The String is analyzed and depending on the String contains, the function is returning an Operation from 
	 * the enum class. This function is very useful in order to get the operation when a ComplexFunction is created by a String or 
	 * at least its Operation.
	 */
	public static Operation StringToOperation(String s) {
		s = s.toLowerCase();
		if (s.equals("plus") || s.equals("add")) {
			return  Operation.Plus;
		}
		else if (s.equals("times") || s.equals("mul")) {
			return Operation.Times;
		}
		else if (s.equals("div") || s.equals("divide") || s.equals("divid")) {
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

	/*
	 * Implementing the f function from complex_function interface.
	 * Computes the value of f(x) for a given number x.
	 * In more detailed, the function is computing the value for each side of the function and
	 * then performs the operation between each side (Operation from enum class).
	 */
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

	/*
	 * Implementing the initFromString function from complex_function interface.
	 * Initialize a ComplexFunction of type "function" from a String by simply sending the String to the proper
	 * ComplexFunction constructor.
	 */
	@Override
	public function initFromString(String s) {
		if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == 'x' || s.charAt(0) == '-' || s.charAt(0) == '+') {
			return new Polynom(s);
		}
		ComplexFunction ans = new ComplexFunction(s);
		return ans;
	}

	/*
	 * Function that turns a function into a String.
	 * Returns a String.
	 */
	public String toString() {
		String ans = "";
		if (this.left != null && this.right != null) {
			ans =  this.op.toString() + "(" + this.left.toString() + "," + this.right.toString() + ")";
		}
		if (this.right == null && this.left != null) {
			ans = this.left.toString();
		}
		return ans;
	}

	/*
	 * Implementing the copy function from complex_function interface.
	 * Performs a deep copy of a given function.
	 */
	@Override
	public function copy() {
		String temp = this.toString();
		ComplexFunction ans = new ComplexFunction(temp);
		return ans;
	}

	/*
	 * Implementing the plus function from complex_function interface.
	 * Copies this function and put it on left side of the ComplexFunction and f1 on the right side of it. 
	 * Sets the operation "plus" between this function and f1.
	 */
	@Override
	public void plus(function f1) {
		if (this.left == null && this.right == null) {
			this.left = f1.copy();
			return;
		}
		if(this.right == null) {
			this.op = Operation.Plus;
			this.right = f1.copy();
			return;
		}
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Plus;
		this.right = f1;
	}

	/*
	 * Implementing the mul function from complex_function interface.
	 * Copies this function and put it on left side of the ComplexFunction and f1 on the right side of it. 
	 * Sets the operation "multiply" between this function and f1.
	 */	
	@Override
	public void mul(function f1) {
		if (this.left == null && this.right == null) {
			this.left = f1.copy();
			return;
		}
		if(this.right == null) {
			this.op = Operation.Times;
			this.right = f1.copy();
			return;
		}
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Times;
		this.right = f1;
	}

	/*
	 * Implementing the div function from complex_function interface.
	 * Copies this function and put it on left side of the ComplexFunction and f1 on the right side of it. 
	 * Sets the operation "divide" between this function and f1.
	 */
	@Override
	public void div(function f1) {
		if (this.left == null && this.right == null) {
			this.left = f1.copy();
			return;
		}
		if(this.right == null) {
			this.op = Operation.Divid;
			this.right = f1.copy();
			return;
		}
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Divid;
		this.right = f1;
	}

	/*
	 * Implementing the max function from complex_function interface.
	 * Copies this function and put it on left side of the ComplexFunction and f1 on the right side of it. 
	 * Sets the operation "maximum" between this function and f1.
	 */
	@Override
	public void max(function f1) {
		if (this.left == null && this.right == null) {
			this.left = f1.copy();
			return;
		}
		if(this.right == null) {
			this.op = Operation.Max;
			this.right = f1.copy();
			return;
		}
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Max;
		this.right = f1;
	}

	/*
	 * Implementing the min function from complex_function interface.
	 * Copies this function and put it on left side of the ComplexFunction and f1 on the right side of it. 
	 * Sets the operation "minimum" between this function and f1.
	 */
	@Override
	public void min(function f1) {
		if (this.left == null && this.right == null) {
			this.left = f1.copy();
			return;
		}
		if(this.right == null) {
			this.op = Operation.Min;
			this.right = f1.copy();
			return;
		}
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Min;
		this.right = f1;
	}

	/*
	 * Implementing the comp function from complex_function interface.
	 * Copies this function and put it on left side of the ComplexFunction and f1 on the right side of it. 
	 * Sets the operation "compare" between this function and f1.
	 */
	@Override
	public void comp(function f1) {
		if (this.left == null && this.right == null) {
			this.left = f1.copy();
			return;
		}
		if(this.right == null) {
			this.op = Operation.Comp;
			this.right = f1.copy();
			return;
		}
		function temp = this.copy();
		this.left = temp;
		this.op = Operation.Comp;
		this.right = f1;
	}

	/*
	 * Implementing the left function from complex_function interface.
	 * Returns the left side of this function.
	 */
	@Override
	public function left() {
		return this.left;
	}

	/*
	 * Implementing the right function from complex_function interface.
	 * Returns the right side of this function.
	 */
	@Override
	public function right() {
		return this.right;
	}

	/*
	 * Implementing the getOp function from complex_function interface.
	 * Returns the Operation of this function.
	 */
	@Override
	public Operation getOp() {
		return this.op;
	}

	/*
	 * Compares between the Strings of this ComplexFunction and another given ComplexFunction.
	 * Returns true or false.
	 */
	public boolean equals(ComplexFunction cf) {
		String s1 = this.toString();
		String s2 = cf.toString();
		return s1.equals(s2);
	}

	/*
	 * This function is checking if this ComplexFunction is equal to another given ComplexFunction.
	 * The user gives a range (start,end), and a number of steps.
	 * The equality is verified only if the calculations of f(x) for this function and the given function are equal for 
	 * all the values between the starting point to the end point (both of them included) in a certain number of steps. 
	 * If the calculation for both of them is equal, the function returns true. If not the function returns false.
	 */
	public boolean equalsIn(ComplexFunction cf, double start, double end,int steps) {
		double plus = Math.abs(end-start) / steps;
		for (double i = start; i <= end; i = i + plus) {
			if (this.f(i) != cf.f(i)) {
				return false;
			}
		}
		return true;
	}
}