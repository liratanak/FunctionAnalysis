package parser.compound.binary;

import parser.AllExpressionParser;
import tools.Functions;
import expr.Expression;
import expr.compound.binary.LogarithmeExpression;

public class LogarithmExpressionParser extends BinaryExpressionParser {

	public static LogarithmExpressionParser instance = new LogarithmExpressionParser();
	private LogarithmExpressionParser(){} ;
	
	@Override
	public Expression parseExpression(String s) {
		
		if( ! s.substring(1 , 6).equals("log[(") )
			return null ;
		
		try{
			
			// 	(log[(x)]( (x)+(1) )
			String e1 = Functions.extractExpression(s, 5) ;
			String e2 = Functions.extractExpression(s, e1.length()+6) ;
			char opt  = '#' ; //For ONLY log 
					//s.charAt(e1.length()+1) ;

			Expression exp1 = AllExpressionParser.instance.parseExpression(e1) ;
			Expression exp2 = AllExpressionParser.instance.parseExpression(e2) ;
			
			if(exp1 == null || exp2 == null) return null;
			
			return parseExpression(exp1 , exp2 , opt);
		}catch (StringIndexOutOfBoundsException e) {
			return null ;
		}catch (NullPointerException e) {
			return null ;
		}
	}

	@Override
	public Expression parseExpression(Expression exp1, Expression exp2, char opt) {
		if( opt == '#' ) return new LogarithmeExpression(exp1, exp2) ;
		return null;
	}

}
