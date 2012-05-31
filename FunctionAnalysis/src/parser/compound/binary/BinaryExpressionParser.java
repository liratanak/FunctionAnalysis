package parser.compound.binary;

import expr.Expression;
import parser.AllExpressionParser;
import parser.compound.CompoundExpressionParser;
import tools.Functions;

public abstract class BinaryExpressionParser extends CompoundExpressionParser {
	
	@Override
	public Expression parseExpression(String s) {
		try{
			String e1 = Functions.extractExpression(s, 1) ;
			String e2 = Functions.extractExpression(s, e1.length()+2) ;
			char opt  = s.charAt(e1.length()+1) ;

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
	
	public abstract Expression parseExpression(Expression exp1 , Expression exp2 , char opt) ;
}
