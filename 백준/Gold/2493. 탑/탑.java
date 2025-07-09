import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] signals = new int[n];
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] <= current) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                signals[i] = stack.peek()[0] + 1; // 0-based to 1-based
            } else {
                signals[i] = 0;
            }

            stack.push(new int[]{i, current});
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int s : signals) {
            bw.write(s + " ");
        }
        bw.flush();
        bw.close();
    }
}