package expr.compound.binary;

import expr.Expression;
import expr.simple.ConstantExpression;

public class SubExpression extends BinaryExpression {
	
	public SubExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Expression derivative() {
		
		if( e1 instanceof ConstantExpression && e2 instanceof ConstantExpression ){
			return new ConstantExpression(0.0) ;
		}else{
		
			if( e1 instanceof ConstantExpression ){
				return e2.derivative() ;
			}
			
			if( e2 instanceof ConstantExpression ){
				return e1.derivative() ;
			}
		}
		
		return new SubExpression(
				e1.derivative()
				, 
				e2.derivative()
				);
	}

	@Override
	public char getOperator() {
		return '-' ;
	}

	@Override
	public Expression simplify() {
		
		if ( (e1 instanceof ConstantExpression) && (e2 instanceof ConstantExpression) ){
			return new ConstantExpression(
					((ConstantExpression)e1).getValue()
					-
					((ConstantExpression)e2).getValue()
					);
		}
		
		
		if( e1.equals(new ConstantExpression()) && e2.equals(new ConstantExpression()) ){
			return new ConstantExpression();
//		}else if( e1.equals(new ConstantExpression()) ){
//			return e2.simplify() ;
//		}else if( e2.equals(new ConstantExpression()) ){
//			return e1.simplify() ;
		}
		return this;
	}

	@Override
	public double calculate(double value) {
		return e1.calculate(value) - e2.calculate(value);
	}
}
