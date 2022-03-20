import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1987 {

    static int[] mr = {0,0,1,-1}, mc = {1,-1,0,0};
    static int answer = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[26];
        String[] board = new String[R];
        for(int i = 0; i < R; i++){
            board[i] = br.readLine();
        }

        dfs(1,R,C,0,0,visited,board);
        System.out.println(answer);
        return;
    }
    static void dfs(int cnt, int R, int C, int r, int c, boolean[] visited, String[] board) {

        char ch = board[r].charAt(c);
        visited[ch-'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = mr[i] + r;
            int nextC = mc[i] + c;
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
            char nextCh = board[nextR].charAt(nextC);
            if (!visited[nextCh-'A']) {
                visited[nextCh-'A'] = true;
                if(cnt+1 > answer) answer = cnt+1;
                dfs(cnt+1, R,C,nextR,nextC,visited,board);
                visited[nextCh-'A'] = false;
            }
        }
    }
}

