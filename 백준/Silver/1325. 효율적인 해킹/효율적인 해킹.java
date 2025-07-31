import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        counts = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            counts[i] = bfs(i);
        }

        int maxV = Arrays.stream(counts).max().getAsInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            if (counts[i] == maxV) sb.append(i + " ");
        }

        System.out.println(sb);
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }

        }

        return cnt;
    }
}