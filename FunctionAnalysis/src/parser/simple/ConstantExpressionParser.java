package parser.simple;

import expr.Expression;
import expr.simple.ConstantExpression;

public class ConstantExpressionParser extends SimpleExpressionParser {

	private ConstantExpressionParser(){};
	public static ConstantExpressionParser instance = new ConstantExpressionParser();
	
	
	@Override
	public Expression parseExpression(String s) {
		if(s.charAt(0) == '(' && s.charAt(s.length()-1) == ')'){
			try{
				double d = Double.parseDouble(s.substring(1, s.length()-1)) ;
				return new ConstantExpression(d);
			}catch (NumberFormatException e) {
				return null ;
			}
		}
		return null;
	}

}
