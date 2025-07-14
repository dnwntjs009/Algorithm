import java.util.*;

public class Main {
    public static boolean isPalindrome(char[] arr, int lt, int rt) {
        while (lt < rt) {
            if (arr[lt] != arr[rt]) return false;
            lt++;
            rt--;
        }
        return true;
    }

    public static int checkPalindrome(char[] arr) {
        int lt = 0, rt = arr.length - 1;

        while (lt < rt) {
            if (arr[lt] == arr[rt]) {
                lt++;
                rt--;
            } else {
                if (isPalindrome(arr, lt + 1, rt) || isPalindrome(arr, lt, rt - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            char[] arr = sc.next().toCharArray();
            int result = checkPalindrome(arr);
            System.out.println(result);
        }
    }
}