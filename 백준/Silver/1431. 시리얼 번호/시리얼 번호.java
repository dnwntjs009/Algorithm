import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        arr[0] = sc.next();
        String cool = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i] = sc.next();
            for (int j = i; j > 0; j--) {
                if (arr[j].length() < arr[j - 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else if (arr[j].length() == arr[j - 1].length()) {
                    char[] str1 = arr[j].toCharArray();
                    char[] str2 = arr[j-1].toCharArray();
                    int sum1 = 0, sum2 = 0;
                    for (int k = 0; k < str1.length; k++) {
                        if (Character.isDigit(str1[k])) sum1 += str1[k] - '0';
                        if (Character.isDigit(str2[k])) sum2 += str2[k] - '0';
                    }
                    if (sum1 < sum2) {
                        String temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    } else if (sum1 == sum2) {
                        if (arr[j].compareTo(arr[j - 1]) < 0) {
                            String temp = arr[j];
                            arr[j] = arr[j - 1];
                            arr[j - 1] = temp;
                        }
                    }
                }
            }
        }
        for (String s : arr) {
            System.out.println(s);
        }
    }
}