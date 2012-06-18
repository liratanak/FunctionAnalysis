package expr.simple;

import expr.Expression;
import expr.compound.binary.DivExpression;
import expr.compound.binary.MulExpression;
import expr.compound.binary.PowerExpression;

public class LogarithmNaturalExpression extends SimpleExpression {
	private Expression e ;
	
	public LogarithmNaturalExpression(Expression e){
		this.e = e.simplify() ;
	}
	
	@Override
	public Expression derivative() {
		if( e instanceof ConstantExpression ){
			return new ConstantExpression() ;
		}
		return new DivExpression(e.derivative(), e);
	}

	@Override
	public Expression simplify() {
		
		if( e instanceof PowerExpression ){
			return new MulExpression(((PowerExpression) e).getPower()
					, new LogarithmNaturalExpression(((PowerExpression) e).getBase())
					) ;
		}else if(e instanceof ExpoBaseEExpression){
			return ((ExpoBaseEExpression) e).getPower() ; 
		}
		
		
		
		if( e.equals(new ConstantExpression(1)) ){
			return new ConstantExpression();
		}else if( e.equals(new ConstantExpression(Math.E)) ){
			return new ConstantExpression(1) ;
		}
		return this;
	}
	
	public String toString(){
		if( e instanceof SimpleExpression )
			return "ln" + e.toString() ;
		else
			return "ln(" + e.toString() + ")" ;
	}

	@Override
	public double calculate(double value) {
		return Math.log(value);
	}
}
