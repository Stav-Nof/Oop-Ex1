package Ex1;

public class ComplexFunction implements complex_function{
	function left;
	function right;
	Operation op;

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
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public void plus(function f1) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		return null;
	}

}
