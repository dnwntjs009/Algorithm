import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(n, m, arr));
    }

    static int bfs(int n, int m, int[][] arr) {
        boolean[][] visited = new boolean[n][m];
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int i = cur[0], j = cur[1], cnt = cur[2];

            if (i == n-1 && j == m-1) return cnt;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k], nj = j + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < m && arr[ni][nj] == 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj, cnt+1});
                }
            }
        }
        return -1;
    }
}