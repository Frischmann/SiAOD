package Calculator;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static int evaluate(String mathLine) {
        char[] nums = mathLine.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ' ')
                continue;

            if (nums[i] >= '0' && nums[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while (i < nums.length && nums[i] >= '0' && nums[i] <= '9')
                    sbuf.append(nums[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }

            else if (nums[i] == '(')
                ops.push(nums[i]);

            else if (nums[i] == ')') {
                while (ops.peek() != '(')
                    values.push(resultOperation(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (nums[i] == '+' || nums[i] == '-' || nums[i] == '*' || nums[i] == '/') {
                while (!ops.empty() && operationRangs(nums[i], ops.peek()))
                    values.push(resultOperation(ops.pop(), values.pop(), values.pop()));

                ops.push(nums[i]);
            }
        }

        while (!ops.empty())
            values.push(resultOperation(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean operationRangs(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;

        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    public static int resultOperation(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("На нуль делить нельзя!");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение через пробел: ");
        String mathLine = input.nextLine();
        System.out.print("Ответ: ");
        System.out.println(Calculator.evaluate(mathLine));
    }
}
