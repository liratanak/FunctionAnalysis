package expr;

public interface Expression {
	
	public char variable = 'x' ;
	public Expression derivative();
	public Expression simplify();
	
}
