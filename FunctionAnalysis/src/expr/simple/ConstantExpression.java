package expr.simple;

import tools.Functions;
import tools.MathTools;
import expr.Expression;

public class ConstantExpression extends SimpleExpression {
	
	private double value ;
	
	public ConstantExpression(double val){
		this.value = val ;
	}
	
	public ConstantExpression(){
		this.value = 0.0 ;
	}
	
	public ConstantExpression(ConstantExpression c){
		this.value = c.value ;
	}
	
	public String toString(){
		if( MathTools.compareDouble(this.value, Math.E) ){
			return "e" ;
		}else {
			return "" + Functions.strDouble(this.value , MathTools.precision) ;
		}
	}
	
	public double getValue(){
		return this.value ;
	}

	@Override
	public Expression derivative() {
		return new ConstantExpression(0.0);
	}

	@Override
	public Expression simplify() {
		return this;
	}
	
	public boolean equals(Object o){
		if ( o.getClass() == this.getClass() ){
			if( ((ConstantExpression) o).getValue() == this.getValue()
					|| MathTools.compareDouble(((ConstantExpression) o).getValue() 
							, this.getValue())
					){
				return true ;
			}
		}
		return false;
		
	}

	@Override
	public double calculate(double value) {
		return this.value;
	}
}
