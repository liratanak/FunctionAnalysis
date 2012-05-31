/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


public class Functions {

	public static String extractExpression(String s , int start){
		if(s.charAt(0) != '(') return null;
		int end = start ;
		int nbOpen = 0 ;
		for(int i=start ; i<s.length() ; i++){
			if( s.charAt(i) == '(' ){
				nbOpen++;
			}else if( s.charAt(i) == ')' ){
				nbOpen--;
			}
			end++;
			if(nbOpen == 0 ){
				break;
			}
		}
		return s.substring(start, end);
	}
	
	
    public static String filterString(String string, char c) {
        String filtered = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != c) {
                filtered += string.charAt(i);
            }
        }
        return filtered;
    }

    public static String filterSpace(String s){
    	return filterString(s, ' ') ;
    }
    
    public static String strDouble(double value) {
        String string = "";
        if (MathTools.isInteger(value)) {
            string = String.valueOf(Math.round(value));
        } else {
            string = String.valueOf(value);
        }
        return string;
    }

    public static String strDouble(double value, int precision) {
        if (MathTools.isInteger(value)) {
            return strDouble(value);
        } else {
            String s = String.valueOf(value);
            
            int dotPos = 2;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '.') {
                    dotPos++;
                } else if (s.charAt(i) == '.') {
                    break;
                }
            }
            	
            String zero = "0" ;
            String str = "" ;
            
            if ((dotPos + precision) < s.length()) {
                str = s.substring(0, dotPos + precision);
                zero += "0" ;
            }else{
                return s ;
            }
           
            if(str.substring(dotPos).equals(zero)){
            	int counter = dotPos ;
            	for(int i=dotPos ; i<s.length() ; i++){
            		counter++ ;
            		if(s.charAt(i) != '0'){
            			break;
            		}
            	}
            	str = s.substring(0, counter) ;
            }
            
            return str;
        }
    }
}
