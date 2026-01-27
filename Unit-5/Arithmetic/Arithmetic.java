public class Arithmetic {

    // Evaluates a String exp that has an arithmetic expression, written in classic
    // notation

    public static int evaluate(String exp) {
        String temp = convertClassicToStout(exp);
        return evaluateStout(temp);

    }

    // Returns the result of doing operand1 operation operand2,

    // e.g. operate(5, 2, "-") should return 3

    public static int operate(int operand1, int operand2, String operation) {
        if (operation.equals("+")) {
            return operand1 + operand2;
        }
        if (operation.equals("-")) {
            return operand1 - operand2;
        }
        if (operation.equals("/")) {
            return operand1 / operand2;
        }
        if (operation.equals("*")) {
            return operand1 * operand2;
        }
        if (operation.equals("%")) {
            return operand1 % operand2;
        } else {
            return 0;
        }
    }

    // Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation

    public static int evaluateStout(String exp) {
        MyStack<Integer> stack = new MyStack<>();
        int i = 0;
        while (i < exp.length()) {
            char c = exp.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                int number = 0;
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    number = number * 10 + (exp.charAt(i) - '0');
                    i++;
                }
                stack.push(number);
            } else if (isOperator(c)) {
                int right = stack.pop();
                int left = stack.pop();
                int result = operate(left, right, String.valueOf(c));
                stack.push(result);
                i++;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return stack.pop();
    }

    public static String convertClassicToStout(String exp) {
        StringBuilder output = new StringBuilder();
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character c = exp.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (isDigit(c)) {
                StringBuilder number = new StringBuilder();
                int j = i;
                while (j < exp.length() && isDigit(exp.charAt(j))) {
                    number.append(exp.charAt(j));
                    j++;
                }
                output.append(number.toString()).append(' ');
                i = j - 1;
                continue;
            }
            if (isDigit(c)) {
                output.append(c).append(' ');
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    throw new IllegalArgumentException("Lonely Parenthesis");
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != null && isOperator(stack.peek())
                        && operatorValue(stack.peek()) >= operatorValue(c)) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }
        return output.toString();
    }

    public static boolean isOperator(Character c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            return true;
        }
        return false;
    }

    public static int operatorValue(Character opChar) {
        if (opChar == '+' || opChar == '-') {
            return 1;
        }
        if (opChar == '*' || opChar == '/' || opChar == '%') {
            return 2;
        }
        return 0;
    }

    public static boolean isDigit(Character letter) {
        if (letter >= 48 && letter < 58) {
            return true;
        }
        return false;
    }

}
