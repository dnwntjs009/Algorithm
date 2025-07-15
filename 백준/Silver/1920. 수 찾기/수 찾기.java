import java.io.*;
import java.util.*;

public class Main {
    public static int binary1(int[] arr, int n) {
        int lt = 0, rt = arr.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == n) {
                return 1;
            } else if (arr[mid] < n) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binary1(arr, Integer.parseInt(st.nextToken())) + "\n");
        }

        System.out.println(sb);
    }
}