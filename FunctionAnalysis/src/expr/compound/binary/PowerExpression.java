package expr.compound.binary;

import expr.Expression;
import expr.simple.ConstantExpression;
import expr.simple.ExpoBaseEExpression;
import expr.simple.LogarithmNaturalExpression;

public class PowerExpression extends BinaryExpression {

	public PowerExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	public Expression getBase(){
		return e1 ;
	}
	
	public Expression getPower(){
		return e2 ;
	}
	
	@Override
	public Expression derivative() {
		
		if ( (e1 instanceof ConstantExpression) && (e2 instanceof ConstantExpression) )
			return new ConstantExpression();
		
		if ( e1 instanceof ConstantExpression ){
			if ( ( 	e1.equals(new ConstantExpression()) 
					|| 
					e1.equals(new ConstantExpression(1.0)) )
						
					&& (!e2.equals(new ConstantExpression()))
					){
				return new ConstantExpression() ;
			}
			
			return new MulExpression(
					new MulExpression(e2.derivative() , this)
					,
					new LogarithmNaturalExpression(e1) 
					);
		}
		
		if ( e2 instanceof ConstantExpression ){
			if( e2.equals(new ConstantExpression()) && (!e1.equals(new ConstantExpression())) ){
				return new ConstantExpression();
			}else if( e2.equals(new ConstantExpression(1.0)) ){
				return e1.derivative();
			}
			double pow =  ((ConstantExpression)e2).getValue() ;
			return new MulExpression( new ConstantExpression(pow) 
				, new MulExpression(e1.derivative()
						, 
						new PowerExpression(e1, new ConstantExpression(pow - 1.0))
						)
				);
		}
		
		return new MulExpression(this
				, 
				new AddExpression(
						new MulExpression(e2.derivative()
								, new LogarithmNaturalExpression(e1)
						)
						, 
						new DivExpression(
								new MulExpression(e1.derivative()
										, 
										e2
										)
								, e1
								)
						)
				);
	}

	@Override
	public Expression simplify() {
		
		if ( (e1 instanceof ConstantExpression) && (e2 instanceof ConstantExpression) ){
			return new ConstantExpression(
					Math.pow(
						((ConstantExpression)e1).getValue()
						,
						((ConstantExpression)e2).getValue()
					)
					);
		}
		
		
		if( e1.equals(new ConstantExpression(1.0)) ){
			return new ConstantExpression(1.0) ;
		}else if( e1.equals(new ConstantExpression()) ){
			return new ConstantExpression();
		}else if( e1.equals(new ConstantExpression(Math.PI)) ){
			return new ExpoBaseEExpression(e2).simplify() ;
		}
		
		if( e2.equals(new ConstantExpression(1.0)) ){
			return e1.simplify() ;
		}else if( e2.equals(new ConstantExpression()) ){
			return new ConstantExpression(1.0);
		}
		
		return this;
	}

	@Override
	public char getOperator() {
		return '^';
	}

}
