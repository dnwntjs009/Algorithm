import java.io.*;
import java.util.*;

public class Main {
    public static int check(int[] arr, int key) {
        int last = arr[0], cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= key) {
                last = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1, rt = arr[n-1], result = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(arr, mid) >= c) {
                lt = mid + 1;
                result = mid;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(result);
    }
}