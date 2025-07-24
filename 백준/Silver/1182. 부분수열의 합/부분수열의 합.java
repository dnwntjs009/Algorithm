import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs1(0, 0);

        if (s == 0) cnt--;

        System.out.println(cnt);
    }

    static void dfs1(int l, int sum) {
        if (l == n) {
            if (sum == s) cnt++;
            return;
        }

        dfs1(l+1, sum + arr[l]);
        dfs1(l+1, sum);
    }
}