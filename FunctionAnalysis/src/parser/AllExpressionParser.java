package parser;

import java.util.ArrayList;

import expr.Expression;

public class AllExpressionParser implements ExpressionParser {
	
	private ArrayList<ExpressionParser> parserList = new ArrayList<ExpressionParser>();
	
	private AllExpressionParser(){};
	public static AllExpressionParser instance = new AllExpressionParser();
	
	
	public void addParser(ExpressionParser ep){
		parserList.add(ep);
	}

	@Override
	public Expression parseExpression(String s) {
		try{
			for(ExpressionParser ep : parserList){
				Expression exp = ep.parseExpression(s) ;
				if(exp != null) return exp ;
			}
		}catch (Exception e) {
			return null ;
		}
		return null;
	}

}
