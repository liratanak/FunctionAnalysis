package expr.compound.binary;

import expr.Expression;
import expr.simple.ConstantExpression;

public class DivExpression extends BinaryExpression {
	
	public DivExpression(Expression e1, Expression e2) { 
		super(e1, e2);
	}

	@Override
	public Expression derivative() {
		
		if ( e1 instanceof ConstantExpression ){
			if( e1.equals(new ConstantExpression()) ){
				return new ConstantExpression();
			}else{
				return new DivExpression(
						new MulExpression(
								new ConstantExpression( (-1.0)*(((ConstantExpression)e1).getValue()) )
								, e2.derivative())
						, 
						new PowerExpression(e2, new ConstantExpression(2))
						) ;
			}
		}
		
		if( e2 instanceof ConstantExpression ){
			if( e2.equals(new ConstantExpression(1.0))){
				return e1.derivative() ;
			}
			return new MulExpression( e1 , 
					new ConstantExpression( 1.0/(((ConstantExpression)e2).getValue()) )
			).derivative() ;
		}
		
		return new DivExpression(
				new SubExpression(
						new MulExpression(e1.derivative(), e2)
						,
						new MulExpression(e1, e2.derivative())
						)
				, 
				new PowerExpression(e2, new ConstantExpression(2.0))
				);
	}


	@Override
	public char getOperator() {
		return '/';
	}

	@Override
	public Expression simplify() {
		
		if ( (e1 instanceof ConstantExpression) && (e2 instanceof ConstantExpression) ){
			return new ConstantExpression(
					((ConstantExpression)e1).getValue()
					/
					((ConstantExpression)e2).getValue()
					);
		}
		
		
		if( e1.equals(new ConstantExpression()) ){
			return new ConstantExpression();
		}
		
		if( e2.equals(new ConstantExpression(1.0)) ){
			return e1.simplify() ;
		}
		
		return this;
	}
}
