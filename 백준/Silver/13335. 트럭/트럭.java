import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int weight = 0;
        int idx = 0;

        for (int i = 0; i < w; i++) bridge.add(0);

        while (idx < n) {
            time++;

            weight -= bridge.poll();

            if (weight + arr[idx] <= l) {
                bridge.offer(arr[idx]);
                weight += arr[idx];
                idx++;
            } else bridge.add(0);
        }

        time += w;

        System.out.println(time);

    }
}
