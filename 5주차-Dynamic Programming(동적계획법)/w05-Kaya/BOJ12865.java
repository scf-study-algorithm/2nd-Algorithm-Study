import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] w, v;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = new int[n+1];
        v = new int[n+1];
        dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}

