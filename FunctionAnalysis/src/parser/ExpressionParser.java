package parser;

import expr.Expression;

public interface ExpressionParser {
	public Expression parseExpression(String s);
}
