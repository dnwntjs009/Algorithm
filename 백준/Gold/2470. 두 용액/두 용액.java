import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int result = (int) 21e8;
        int a = 0, b = 0;

        int p1 = 0, p2 = n-1;
        while (p1 < p2) {
            if (Math.abs(arr[p1] + arr[p2]) < result) {
                result = Math.abs(arr[p1] + arr[p2]);
                a = arr[p1];
                b = arr[p2];
            }
            if (arr[p1] + arr[p2] < 0) p1++;
            else if (arr[p1] + arr[p2] >= 0) p2--;
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a + " " + b);
    }
}