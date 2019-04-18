import java.lang.*;

public class Main {

    static int lastIndexofLeft = 0;
    static int firstIndexofRight = 0;
    static int parenthesisCount = 0;

    public static void main(String[] args){

        System.out.println(reverseInParentheses("foo(bar(baz))blim"));

    }

    private static String reverseInParentheses(String inputString) {

        parenthesisCount = inputString.length() - inputString.replace("(", "").length();

        if(inputString.isEmpty())
            return "";

        if(parenthesisCount == 2 && inputString.length() == 2)
            return "";

        for(int i = 0; i < parenthesisCount; i++){

            lastIndexofLeft = inputString.lastIndexOf("(");
            firstIndexofRight = inputString.indexOf(")", lastIndexofLeft);

            String reversed = getReverse(inputString.substring(lastIndexofLeft + 1, firstIndexofRight));
            inputString = inputString.replace("(" + inputString.substring(lastIndexofLeft + 1, firstIndexofRight) + ")", reversed);

        }

        return inputString;
    }

    private static String getReverse(String substring) {

        return new StringBuilder(substring).reverse().toString();

    }

}
