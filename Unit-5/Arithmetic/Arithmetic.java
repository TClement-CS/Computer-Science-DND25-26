package Arithmetic;

import MyStack;

public class Arithmetic {

    // Evaluates a String exp that has an arithmetic expression, written in classic
    // notation

    public static int evaluate(String exp) {

        return 0;

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
        } else {
            return 0;
        }
    }

    // Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation

    public static int evaluateStout(String exp) {
        MyStack<Character> stack = new MyStack();
        Character temp1 = null;
        Character temp2 = null;
        for (int i = 0; i < exp.length(); i++) {
            stack.push(exp.charAt(i));
        }
        if (stack.peek() >= 48 && stack.peek() < 58) {
            temp1 = stack.pop();
        } else {

        }

    }

    public static String convertClassicToStout(String exp) {
        StringBuilder output = new StringBuilder();
        MyStack<Character> stack = new MyStack();
        for (int i = 0; i < exp.length(); i++) {
            if (isDigit(exp.charAt(i))) {
                output.append(exp.charAt(i));
            } else {
                if (stack.peek() > exp.charAt(i)) {
                    output.append(stack.pop());
                    stack.push(exp.charAt(i));
                }
            }
        }
        return output.toString();

    }

    public static boolean isDigit(Character letter) {
        if (letter >= 48 && letter < 58) {
            return true;
        }
        return true;
    }

}
