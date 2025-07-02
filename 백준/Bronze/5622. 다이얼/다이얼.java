import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] s = str.toCharArray();

        int result = 0;
        for (char c : s) {
            if (c == 'A' | c == 'B' | c == 'C') {
                result += 3;
            } else if (c == 'D' | c == 'E' | c == 'F') {
                result += 4;
            } else if (c == 'G' | c == 'H' | c == 'I') {
                result += 5;
            } else if (c == 'J' | c == 'K' | c == 'L') {
                result += 6;
            } else if (c == 'M' | c == 'N' | c == 'O') {
                result += 7;
            } else if (c == 'P' | c == 'Q' | c == 'R' | c == 'S') {
                result += 8;
            } else if (c == 'T' | c == 'U' | c == 'V') {
                result += 9;
            } else if (c == 'W' | c == 'X' | c == 'Y' | c == 'Z') {
                result += 10;
            }
        }

        System.out.println(result);
    }
}