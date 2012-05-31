package expr.compound.binary;

import expr.Expression;
import expr.compound.CompoundExpression;
import expr.simple.SimpleExpression;

public abstract class BinaryExpression extends CompoundExpression {
	protected Expression e1 , e2 ;
	
	public BinaryExpression(Expression e1 , Expression e2){
		this.e1 = e1.simplify() ;
		this.e2 = e2.simplify() ;
	}
	
	public abstract char getOperator() ;
	
	
	public String toString(){
		
		String s = "" ;
		if( e1 instanceof SimpleExpression || e1 instanceof LogarithmeExpression ){
			s = e1.toString();
		}else{
			s =  "(" +   e1.toString()  + ")"  ;
		}
		
		s += this.getOperator() ;
		
		if( e2 instanceof SimpleExpression || e2 instanceof LogarithmeExpression ){
			s +=  e2.toString() ;
		}else{
			s += "(" + e2.toString() + ")" ;
		}
		
		return s;
	}
}
