class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        int[][] map = new int[n+1][m+1];
        
        map[1][1] = 1;
        for(int i=0; i< puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            map[x][y] = -1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(map[i][j] == -1) continue;
                if(map[i-1][j] > 0) {
                    map[i][j] += (map[i-1][j] % mod);
                }
                if(map[i][j-1] > 0) {
                    map[i][j] += (map[i][j-1] % mod);
                }
            }
        }
        
        return answer = map[n][m] % mod;
    }
}