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

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int p1 = 0, p2 = n - 1;
            while (p1 < p2) {
                if (arr[p1] + arr[p2] > arr[i]) {
                    p2--;
                } else if (arr[p1] + arr[p2] < arr[i]) {
                    p1++;
                } else {
                    if (p1 == i) {
                        p1++;
                        continue;
                    } else if (p2 == i) {
                        p2--;
                        continue;
                    } else {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}