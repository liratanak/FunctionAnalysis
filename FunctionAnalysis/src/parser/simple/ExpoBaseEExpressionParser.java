package parser.simple;

import parser.AllExpressionParser;
import tools.Functions;
import expr.Expression;
import expr.simple.ExpoBaseEExpression;

public class ExpoBaseEExpressionParser extends SimpleExpressionParser {

	public static ExpoBaseEExpressionParser instance = new ExpoBaseEExpressionParser();
	private ExpoBaseEExpressionParser(){};
	
	@Override
	public Expression parseExpression(String s) {
		
		/*
		 * Example String
		 * 
		 * (e^((x)+(1)))
		 * 
		 * */
		
		if( ! s.substring(0, 4).equals("(e^("))
			return null ;
		
		String e = Functions.extractExpression(s, 3) ;
		Expression exp = AllExpressionParser.instance.parseExpression(e) ;
		
		if ( exp == null ) return null ;
		
		return new ExpoBaseEExpression(exp);
	}

}
