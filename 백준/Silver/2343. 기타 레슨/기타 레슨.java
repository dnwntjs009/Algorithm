import java.io.*;
import java.util.*;

public class Main {
    public static int check(int[] arr, int key, int m) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= key) {
                sum += arr[i];
            } else {
                cnt += 1;
                sum = arr[i];
            }
        }

        if (cnt <= m) return 1;
        else return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int lt = 0, rt = 0, result =  0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lt = Math.max(lt, arr[i]);
            rt += arr[i];
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(arr, mid, m) == 1) {
                rt = mid - 1;
                result = mid;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(result);
    }
}