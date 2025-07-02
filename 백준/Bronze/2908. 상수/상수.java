import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number1 = sc.next();
        String number2 = sc.next();

        String num1 = new StringBuilder(number1).reverse().toString();
        String num2 = new StringBuilder(number2).reverse().toString();

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);

        System.out.println(Math.max(n1, n2));
    }
}