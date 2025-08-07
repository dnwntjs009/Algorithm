import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        List<Integer> area = new ArrayList<>();

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int ej = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());

            for (int i = si; i < ei; i++) {
                for (int j = sj; j < ej; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    int sum = bfs(i, j);
                    area.add(sum);
                }
            }
        }

        Collections.sort(area);

        System.out.println(area.size());
        for (Integer i : area) {
            System.out.print(i + " ");
        }
    }

    static int bfs(int si, int sj) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{si, sj});
        visited[si][sj] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d], nj = j + dj[d];
                if (0 <= ni && ni < n && 0 <= nj && nj < m && arr[ni][nj] == 0 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    cnt++;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        return cnt;
    }
}