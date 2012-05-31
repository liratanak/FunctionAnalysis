package tools;

public class MathTools {

    private final static double variant = 10E-10;
    public final static int precision = 2;

    public static boolean compareDouble(double a , double b){
        if(isZero(a-b)){
            return true ;
        }else {
            return false ;
        }
    }
    
    public static boolean isInteger(double value) {
        boolean result = false;
        int valueInt = (int) Math.round(value);

        if (java.lang.Math.abs(value - valueInt) < variant) {
            result = true;
        }
        return result;
    }
    
    public static double toInteger(double value){
        if(isInteger(value)){
            return (double) Math.round(value) ;
        }else{
            return value ;
        }
    }

    public static boolean isZero(double zero) {
        String str = Functions.strDouble(zero);
        if ("0".equals(str)
                || str.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    
}
