class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] game = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            game[win][lose] = 1;
        }
        
        // 플로이드-와샬 알고리즘
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(game[j][i] == 1 && game[i][k] == 1) {  // k가 "j한테 진 i"한테 지면 k도 j에게 진 것임
                        game[j][k] = 1;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            int result = 0;
            for(int j=1; j<=n; j++) {
                if(game[i][j] == 1 || game[j][i] == 1) result++;  // i가 j에게 이겼든 졌든 어쨌거나 경기를 한 것과 마찬가지니까
            }
            if(result == n-1) answer++;
        }
        return answer;
    }
}