package expr.compound.binary;

import expr.Expression;
import expr.simple.ConstantExpression;

public class MulExpression extends BinaryExpression {
	
	public MulExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Expression derivative() {
		
		if( e1 instanceof ConstantExpression && e2 instanceof ConstantExpression ){
			return new ConstantExpression(0.0) ;
		}else{
		
			if( e1 instanceof ConstantExpression ){
				return new MulExpression(e1 , e2.derivative()) ;
			}
			
			if( e2 instanceof ConstantExpression ){
				return new MulExpression(e2 , e1.derivative()) ;
			}
		}
		
		return new AddExpression(
				new MulExpression(e1.derivative() , e2)
				, 
				new MulExpression(e1, e2.derivative())
				);
	}

	@Override
	public char getOperator() {
		return '*';
	}

	@Override
	public Expression simplify() {

		if ( (e1 instanceof ConstantExpression) && (e2 instanceof ConstantExpression) ){
			return new ConstantExpression(
					((ConstantExpression)e1).getValue()
					*
					((ConstantExpression)e2).getValue()
					);
		}
		
		
		if( e1.equals(new ConstantExpression(1.0)) ){
//			System.out.println("E1 is one");
			return e2.simplify() ;
		}else if( e1.equals(new ConstantExpression()) ){
			return new ConstantExpression();
		}
		
		if( e2.equals(new ConstantExpression(1.0)) ){
			return e1.simplify() ;
		}else if( e2.equals(new ConstantExpression()) ){
			return new ConstantExpression();
		}
		
		return this;
	}
}
