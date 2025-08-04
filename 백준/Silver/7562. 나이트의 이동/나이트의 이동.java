import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] di = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ei = Integer.parseInt(st.nextToken());
            int ej = Integer.parseInt(st.nextToken());
            boolean[][] visited = new boolean[n][n];

            int result = bfs(si, sj, ei, ej, visited);
            System.out.println(result);
        }
    }

    static int bfs(int si, int sj, int ei, int ej, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{si, sj, 0});
        visited[si][sj] = true;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int i = cur[0], j = cur[1], cnt = cur[2];

            if (i == ei && j == ej) return cnt;

            for (int k = 0; k < 8; k++) {
                int ni = i + di[k], nj = j + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj, cnt+1});
                }
            }
        }
        return -1;
    }
}