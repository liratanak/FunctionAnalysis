package parser.compound.binary;

import expr.Expression;
import expr.compound.binary.SubExpression;

public class SubExpressionParser extends BinaryExpressionParser {

	private SubExpressionParser(){};
	public static SubExpressionParser instance = new SubExpressionParser();
	
	@Override
	public Expression parseExpression(String s) {
		return super.parseExpression(s);
	}

	@Override
	public Expression parseExpression(Expression exp1, Expression exp2, char opt) {
		if(opt == '-') return new SubExpression(exp1, exp2);
		return null;
	}

}
