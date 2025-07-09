import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}