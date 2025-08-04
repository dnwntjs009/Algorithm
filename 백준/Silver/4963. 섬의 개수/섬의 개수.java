import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {0, 1, 0, -1, 1, -1, -1, 1};
    static int[] dj = {1, 0, -1, 0, 1, 1, -1, -1};
    static boolean[][] visited;
    static int[][] arr;
    static int w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int cnt = 0;
            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(cnt);

        }
    }

    static void dfs(int si, int sj) {

        visited[si][sj] = true;

        for (int k = 0; k < 8; k++) {
            int ni = si + di[k], nj = sj + dj[k];
            if (0 <= ni && ni < h && 0 <= nj && nj < w && arr[ni][nj] == 1 && !visited[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }
}