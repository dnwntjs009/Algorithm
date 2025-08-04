import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, height;
    static int[][] arr;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, arr[i][j]);
            }
        }

        int maxV = 0;
        for (int h = 0; h <= height; h++) {
            boolean[][] visited = new boolean[n][n];
            int sumV = checkCount(h, visited);
            maxV = Math.max(maxV, sumV);
        }

        System.out.println(maxV);
    }

    static int checkCount(int h, boolean[][] visited) {
        boolean[][] water = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= h) {
                    water[i][j] = true;
                }
            }
        }
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!water[i][j] && !visited[i][j]) {
                    cnt++;
                    bfs(i, j, visited, water);
                }
            }
        }

        return cnt;
    }

    static void bfs(int si, int sj, boolean[][] visited, boolean[][] water) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{si,sj});
        visited[si][sj] = true;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int i = cur[0], j = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k], nj = j + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < n && !water[ni][nj] && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj});
                }
            }
        }
    }
}