import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            int lt = n-2, rt = n-1;

            while (lt >= 0) {
                if (arr[lt] >= arr[rt]) {
                    rt = lt;
                    lt--;
                } else {
                    result += arr[rt] - arr[lt];
                    lt--;
                }
            }

            sb.append(result + "\n");

        }

        System.out.println(sb);
    }
}