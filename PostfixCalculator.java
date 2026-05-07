public class PostfixCalculator {

    public static double evaluate(String postfix) {
        Stack<Double> stack = new ArrayStack<>();

        String[] tokens = postfix.trim().split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if (isNumber(t)) {
                stack.push(Double.parseDouble(t));
            }
            else {
                double b = stack.pop();  
                double a = stack.pop();  

                if (t.equals("+")) stack.push(a + b);
                else if (t.equals("-")) stack.push(a - b);
                else if (t.equals("*")) stack.push(a * b);
                else if (t.equals("/")) stack.push(a / b);
                else if (t.equals("^")) stack.push(Math.pow(a, b));
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}