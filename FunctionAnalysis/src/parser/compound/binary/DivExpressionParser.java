package parser.compound.binary;

import expr.Expression;
import expr.compound.binary.DivExpression;

public class DivExpressionParser extends BinaryExpressionParser {

	private DivExpressionParser(){};
	public static DivExpressionParser instance = new DivExpressionParser(); 
	
	@Override
	public Expression parseExpression(String s) {
		return super.parseExpression(s);
	}

	@Override
	public Expression parseExpression(Expression exp1, Expression exp2, char opt) {
		if( opt == '/') return new DivExpression(exp1, exp2);
		return null;
	}

}
