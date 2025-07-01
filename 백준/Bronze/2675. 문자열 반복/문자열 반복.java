import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            String s = scanner.next();
            String result = "";

            for (int j = 0; j < s.length(); j++) {
                result += String.valueOf(s.charAt(j)).repeat(r);
            }
            System.out.println(result);
        }
    }
}
