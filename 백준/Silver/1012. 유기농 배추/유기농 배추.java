import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void dfs1(int i, int j, int n, int m) {
        visited[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int ni = di[k] + i, nj = dj[k] + j;
            if (0 <= ni && ni < n && 0 <= nj && nj < m && arr[ni][nj] == 1 && visited[ni][nj] == 0) {
                arr[ni][nj] = 0;
                dfs1(ni, nj, n, m);
            }
        }
    }

    static int[][] visited;
    static int[][] arr;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }

            visited = new int[n][m];

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        arr[i][j] = 0;
                        dfs1(i, j, n, m);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }
}