import java.util.*;

class Solution {

    static int n, m;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int i = cur[0], j = cur[1], c = cur[2];

            if (i == n-1 && j == m-1) return c;

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k], nj = j + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < m && maps[ni][nj] == 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj, c + 1});
                }
            }
        }
        return -1;

    }
}