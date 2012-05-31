package parser.compound.binary;

import expr.Expression;
import expr.compound.binary.AddExpression;

public class AddExpressionParser extends BinaryExpressionParser {

	private AddExpressionParser(){};
	public static AddExpressionParser instance = new AddExpressionParser();
	
	@Override
	public Expression parseExpression(String s) {
		return super.parseExpression(s);
	}

	@Override
	public Expression parseExpression(Expression exp1, Expression exp2, char opt) {
		if(opt == '+') return new AddExpression(exp1, exp2);
		return null;
	}

}
