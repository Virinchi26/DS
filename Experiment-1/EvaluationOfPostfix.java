import java.util.*;

import DSA.intSTACK;
import DSA1.*;

class EvaluationOfPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        intSTACK obj = new intSTACK();
        System.out.print("Enter a postfix equation: ");
        String s = sc.nextLine();
        char[] eq = s.toCharArray();
        int a, b;
        for (int i = 0; i < eq.length; i++) {
            System.out.println(eq[i]);
            if (Character.isDigit(eq[i]))
                obj.push(Character.digit(eq[i], 10));
            else {
                b = obj.peek();
                obj.pop();
                a = obj.peek();
                obj.pop();
                obj.push(operate(a, b, eq[i]));
            }
        }
        System.out.println(obj.peek());
    }

    static int operate(int a, int b, char c) {
        if (c == '+')
            return a + b;
        else if (c == '-')
            return a - b;
        else if (c == '*')
            return a * b;
        else if (c == '/')
            return a / b;
        else if (c == '%')
            return a % b;
        else
            return (int) Math.pow((double) a, (double) b);
    }
}