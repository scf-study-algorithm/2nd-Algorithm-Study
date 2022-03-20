import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2573 {

    static int[] mr = {0,0,1,-1}, mc = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] board = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                board[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        int answer = 0;
        while(melting(R,C,board)) {
            answer++;
            int cnt = 0;
            boolean[][] visited = new boolean[R][C];
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(!visited[i][j] && board[i][j] > 0){
                        cnt++;
                        bfs(R,C,i,j,visited,board);
                    }
                    if(cnt >= 2){
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
        return;
    }
    static boolean melting(int R, int C, int[][] board){
        int[][] b = new int[R][C];
        for(int i = 1; i < R-1; i++){
            for(int j = 1; j < C-1; j++){
                b[i][j] = board[i][j];
            }
        }
        boolean flag = false;
        for(int i = 1; i < R-1; i++){
            for(int j = 1; j < C-1; j++){
                for(int k = 0; k < 4; k++){
                    int nextR = i + mr[k];
                    int nextC = j + mc[k];
                    if(board[i][j] > 0 && b[nextR][nextC] == 0){
                        board[i][j]--;
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
    static void bfs(int R, int C, int r, int c, boolean[][] visited, int[][] board) {

        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        q.add(c);
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int curR = q.poll();
            int curC = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = mr[i] + curR;
                int nextC = mc[i] + curC;
                if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
                if (!visited[nextR][nextC] && board[nextR][nextC] > 0) {
                    visited[nextR][nextC] = true;
                    q.add(nextR);
                    q.add(nextC);
                }

            }
        }
    }
}

