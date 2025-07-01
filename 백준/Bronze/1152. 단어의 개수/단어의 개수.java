import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();

        if (str.isEmpty()) {  // 빈 문자열인지 확인
            System.out.println(0);
        } else {
            String[] s = str.split(" ");
            System.out.println(s.length);
        }
    }
}