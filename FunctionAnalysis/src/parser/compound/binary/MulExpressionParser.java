package parser.compound.binary;

import expr.Expression;
import expr.compound.binary.MulExpression;

public class MulExpressionParser extends BinaryExpressionParser {

	private MulExpressionParser(){};
	public static MulExpressionParser instance = new MulExpressionParser();
	
	@Override
	public Expression parseExpression(String s) {
		return super.parseExpression(s);
	}

	@Override
	public Expression parseExpression(Expression exp1, Expression exp2, char opt) {
		if(opt == '*') return new MulExpression(exp1, exp2);
		return null;
	}

}
