package parser.simple;

import expr.Expression;
import expr.simple.XExpression;

public class XExpressionParser extends SimpleExpressionParser {

	private XExpressionParser(){};
	public static XExpressionParser instance = new XExpressionParser();
	
	@Override
	public Expression parseExpression(String s) {
		if(s.equals("(x)")) return new XExpression();
		return null;
	}

}
