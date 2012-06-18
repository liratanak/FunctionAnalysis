package expr.simple;

import expr.Expression;

public class XExpression extends SimpleExpression {

	public XExpression(){};
	
	public String toString(){
		return "" + Expression.variable ;
	}
	
	@Override
	public Expression derivative() {
		return new ConstantExpression(1.0);
	}

	@Override
	public Expression simplify() {
		return this;
	}

	@Override
	public double calculate(double value) {
		return value;
	}
}
