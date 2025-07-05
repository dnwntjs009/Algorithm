import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0, rt = n - 1, result = (int) 21e8, si = 0, sj = 0;
        while (lt < rt) {
            if (arr[lt] + arr[rt] > 0) {
                if (Math.abs(arr[lt] + arr[rt]) <= result) {
                    result = Math.abs(arr[lt] + arr[rt]);
                    si = arr[lt];
                    sj = arr[rt];
                }
                rt--;
            } else {
                if (Math.abs(arr[lt] + arr[rt]) <= result) {
                    result = Math.abs(arr[lt] + arr[rt]);
                    si = arr[lt];
                    sj = arr[rt];
                }
                lt++;
            }
        }
        System.out.println(si + " " + sj);

    }
}