import java.util.List;

public class Converter {

    private String infix;

    public Converter(String infix) {
        this.infix = infix;
    }

    public String toPostFix() {
        List<String> tokens = ParserHelper.parse(infix.toCharArray());
        Stack<String> stack = new ArrayStack<>();
        String result = "";

        for (int i = 0; i < tokens.size(); i++) {
            String t = tokens.get(i);

            if (isNumber(t)) {
                result += t + " ";
            }
            else if (t.equals("(")) {
                stack.push(t);
            }
            else if (t.equals(")")) {
                while (!stack.isEmpty() && !stack.top().equals("(")) {
                    result += stack.pop() + " ";
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && isOperator(stack.top())
                        && precedence(stack.top()) >= precedence(t)) {
                    result += stack.pop() + " ";
                }
                stack.push(t);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }

        return result.trim();
    }

    private boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    private int precedence(String op) {
        if (op.equals("^")) return 3;
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return 0;
    }
}