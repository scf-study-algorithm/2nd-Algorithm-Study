import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length+1][triangle.length+1];

        dp[1][1] = triangle[0][0];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<=i; j++) {
                dp[i][j] = Math.max(triangle[i-1][j-1] + dp[i-1][j-1], triangle[i-1][j-1] + dp[i-1][j]);
            }
        }

        Arrays.sort(dp[dp.length-1]);

        answer = dp[dp.length-1][dp.length-1];
        return answer;
    }
}