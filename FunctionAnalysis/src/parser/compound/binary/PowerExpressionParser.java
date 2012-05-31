package parser.compound.binary;

import expr.Expression;
import expr.compound.binary.PowerExpression;

public class PowerExpressionParser extends BinaryExpressionParser {

	private PowerExpressionParser(){};
	public static PowerExpressionParser instance = new PowerExpressionParser();
	
	@Override
	public Expression parseExpression(String s) {
		return super.parseExpression(s);
	}

	@Override
	public Expression parseExpression(Expression exp1, Expression exp2, char opt) {	
		if(opt == '^') return new PowerExpression(exp1, exp2);
		return null;
	}

}
