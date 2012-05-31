package expr.simple;

import expr.Expression;
import expr.compound.binary.PowerExpression;

public class ExpoBaseEExpression extends SimpleExpression {
	private Expression e;
	
	public ExpoBaseEExpression(Expression e){
		this.e = e ;
	}
	
	public Expression getPower(){
		return this.e ;
	}
	
	@Override
	public Expression derivative() {
		if( e instanceof ConstantExpression ){
			return new ConstantExpression() ;
		}
		return new PowerExpression(e.derivative(), this);
	}

	@Override
	public Expression simplify() {
		if( e.equals(new ConstantExpression())){
			return new ConstantExpression(1.0);
		}else if( e.equals(new ConstantExpression(1.0)) ){
			return new ConstantExpression(Math.E) ;
		}
		return this;
	}
	
	public String toString(){
		if( e instanceof SimpleExpression )
			return "e^" + e.toString() ;
		else
			return "e^(" + e.toString() + ")" ;
	}

}
