package main;

import expr.Expression;
import parser.AllExpressionParser;
import parser.compound.binary.AddExpressionParser;
import parser.compound.binary.DivExpressionParser;
import parser.compound.binary.LogarithmExpressionParser;
import parser.compound.binary.MulExpressionParser;
import parser.compound.binary.PowerExpressionParser;
import parser.compound.binary.SubExpressionParser;
import parser.simple.ConstantExpressionParser;
import parser.simple.ExpoBaseEExpressionParser;
import parser.simple.LogarithmNaturalExpressionParser;
import parser.simple.XExpressionParser;
import tools.Functions;

public class TestExpression {

	public static void main(String[] args) {
		Expression e = null ;
		//Parsing NO Error
//		String s = " ( (x)  - (x)^(5) ) " ; => " ( (x)  - ((x)^(5)) ) "
		
		String s = " ( (ln( e^(x) )) + ( (x)  - ((x)^(3)) ) )" ;
		
		s = Functions.filterString(s, ' ') ;
		AllExpressionParser ep = AllExpressionParser.instance ;
		
		ep.addParser(AddExpressionParser.instance) ;
		ep.addParser(SubExpressionParser.instance) ;
		ep.addParser(MulExpressionParser.instance);
		ep.addParser(DivExpressionParser.instance) ;
		ep.addParser(PowerExpressionParser.instance) ;
		ep.addParser(XExpressionParser.instance) ;
		ep.addParser(ConstantExpressionParser.instance) ;
		ep.addParser(LogarithmExpressionParser.instance) ;
		ep.addParser(ExpoBaseEExpressionParser.instance) ;
		ep.addParser(LogarithmNaturalExpressionParser.instance) ;
		
		e = AllExpressionParser.instance.parseExpression(s) ;
		System.out.println("e :   " + e);
		e = e.simplify() ;
		System.out.println("eD1 : " + e.derivative() );
		System.out.println("eD2 : " + e.derivative().derivative() );
		System.out.println("\n============================================================\n");
		
		s = "(( ((2.4)*(x))+(0) ) * (1) )" ;
		s = Functions.filterSpace(s) ;
		Expression exp = AllExpressionParser.instance.parseExpression(s) ;
		
		System.out.println(exp);
		System.out.println(exp.simplify());
		
		System.out.println("============================================================\n");
		
		Expression power = AllExpressionParser.instance.parseExpression(Functions.filterSpace(
				"((((12)*((x)^(0)))*(9))+( (x)^(3) ))")) ;
		System.out.println("P : " + power);
//		System.out.println("S : " + power.simplify());
		System.out.println("D : " + power.derivative());
		System.out.println("D2: " + power.derivative().derivative().simplify());
		System.out.println("D3: " + power.derivative().derivative().derivative().simplify());
		System.out.println("D4: " + power.derivative().derivative().derivative().derivative().simplify());
		System.out.println("D5: " + power.derivative().derivative().derivative().derivative().derivative().simplify());
	}

}
