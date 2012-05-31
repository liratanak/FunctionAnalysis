package parser.simple;

import parser.AllExpressionParser;
import tools.Functions;
import expr.Expression;
import expr.simple.LogarithmNaturalExpression;

public class LogarithmNaturalExpressionParser extends SimpleExpressionParser {

	private LogarithmNaturalExpressionParser(){};
	public static LogarithmNaturalExpressionParser instance = new LogarithmNaturalExpressionParser();
	
	@Override
	public Expression parseExpression(String s) {
		
		/*
		 * Example String
		 * 
		 * (ln((x)+(1)))
		 * 
		 * */
		
		if( ! s.substring(0, 4).equals("(ln("))
			return null ;
		
		String e = Functions.extractExpression(s, 3) ;
		Expression exp = AllExpressionParser.instance.parseExpression(e) ;
		
		if ( exp == null ) return null ;
		
		return new LogarithmNaturalExpression(exp);
	}

}
