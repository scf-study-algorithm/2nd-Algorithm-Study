import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2515 {
    static int[] dp = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[][] pic = new int[n][2];
        dp = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pic[i][0] = h;
            pic[i][1] = c;
        }

        Arrays.sort(pic, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        dp[0] = pic[0][1];
        int idx = 0;
        int ans = dp[0];
        for(int i = 1; i < n; i++){
            for(int j = idx; pic[j][0]+ s <= pic[i][0]; j++){
                // 그 전의 것들보다 가장 큰 값으로 갱신되기 때문에
                // 이전의 값을 비교할 필요없다.
                // 그러므로 idx 를 변경해준다.
                if(dp[i] < dp[j] + pic[i][1]){
                    idx = j;
                    dp[i] = dp[j] + pic[i][1];
                }
            }
            // 그 자체로 클 수 있기 때문에 마지막으로 한번더 비교
            dp[i] = Math.max(dp[i], pic[i][1]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}