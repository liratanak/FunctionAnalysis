package expr.compound.binary;

import java.rmi.server.ExportException;

import expr.Expression;
import expr.simple.ConstantExpression;
import expr.simple.LogarithmNaturalExpression;

public class LogarithmeExpression extends BinaryExpression {

	public LogarithmeExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Expression derivative() {
		return new DivExpression(new LogarithmNaturalExpression(e1)
							, 
							new LogarithmNaturalExpression(e2)
							).derivative() ;
	}

	@Override
	public Expression simplify() {
		
		if( e2 instanceof PowerExpression ){
			return new MulExpression(((PowerExpression) e2).getPower()
					, 
					new LogarithmeExpression(e1, ((PowerExpression) e2).getBase())
					) ;
		}else if( e2 instanceof ExportException ){
			return new MulExpression( ((PowerExpression) e2).getPower() 
					, new LogarithmeExpression(e1, new ConstantExpression(Math.E))
					);
		}
		
		if ( (e1 instanceof ConstantExpression) && (e2 instanceof ConstantExpression) ){
			return new ConstantExpression(
					Math.log(((ConstantExpression)e1).getValue())
					/
					Math.log(((ConstantExpression)e2).getValue())
					);
		}
		
		
		if( e1.equals(new ConstantExpression(Math.PI)) ){
			return new LogarithmNaturalExpression(e2).simplify() ;
		}
		
		if( e2.equals(new ConstantExpression(1.0)) ){
			return new ConstantExpression() ;
		}else if( e2.equals(new ConstantExpression(Math.E)) ){
			return new ConstantExpression(1);
		}
		
		return this;
	}

	@Override
	public char getOperator() {
		return 0;
	}
	
	@Override
	public String toString(){
		return "log["+ e1.toString() +"](" + e2.toString() + ")" ; 
	}

	@Override
	public double calculate(double value) {
		return Math.log(e1.calculate(value)) / Math.log(e2.calculate(value)) ;
	}

}
