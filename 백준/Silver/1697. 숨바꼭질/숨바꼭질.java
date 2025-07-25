import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int bfs1(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        visited[s] = true;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int n = arr[0];
            int c = arr[1];

            if (n == e) return c;

            if (0 <= n - 1 && n - 1 < 100001 && !visited[n - 1]) {
                visited[n-1] = true;
                q.offer(new int[]{n - 1, c + 1});
            }
            if (0 <= n + 1 && n + 1 < 100001 && !visited[n + 1]) {
                visited[n + 1] = true;
                q.offer(new int[]{n + 1, c + 1});
            }
            if (0 <= n*2 && n*2 < 100001 && !visited[n*2]) {
                visited[n*2] = true;
                q.offer(new int[]{n*2, c + 1});
            }
        }
        return -1;
    }

    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(bfs1(s, e));
    }
}