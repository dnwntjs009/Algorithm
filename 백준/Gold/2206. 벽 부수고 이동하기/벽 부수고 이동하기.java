import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        boolean[][][] visited = new boolean[2][n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int i = cur[0], j = cur[1], cnt = cur[2], b = cur[3];

            if (i == n-1 && j == m-1) return cnt;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k], nj = j + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < m) {
                    if (arr[ni][nj] == 0) {
                        if (!visited[b][ni][nj]) {
                            visited[b][ni][nj] = true;
                            q.add(new int[]{ni, nj, cnt + 1, b});
                        }
                    } else if (arr[ni][nj] == 1) {
                        if (b == 0 && !visited[1][ni][nj]) {
                            visited[1][ni][nj] = true;
                            q.add(new int[]{ni, nj, cnt + 1, 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}