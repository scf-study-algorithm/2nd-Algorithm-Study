import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10026 {
    static int[] mr = {0,0,1,-1}, mc = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] region = new String[n];
        for(int i = 0; i < n; i++){
            region[i] = br.readLine();
        }

        boolean[][][] visited = new boolean[n][n][2];
        int all = 0, part = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j][0]){
                    seeRGB(0, i, j, n, region, visited);
                    all++;
                }
                if(!visited[i][j][1]){
                    seeRGB(1, i, j, n, region, visited);
                    part++;
                }
            }
        }

        System.out.println(all + " " +part);
    }

    static void seeRGB( int flag, int r, int c, int n, String[] color, boolean[][][] visited){

        Queue<Integer> q = new LinkedList<>();
        visited[r][c][flag] = true;
        char col = color[r].charAt(c);
        q.add(r);
        q.add(c);

        while(!q.isEmpty()){
            int curR = q.poll();
            int curC = q.poll();

            for(int i = 0; i < 4; i++){
                int nextR = mr[i] + curR;
                int nextC = mc[i] + curC;
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
                if(!visited[nextR][nextC][flag] && checkSame(flag, col ,color[nextR].charAt(nextC))){
                    visited[nextR][nextC][flag] = true;
                    q.add(nextR);
                    q.add(nextC);
                }
            }
        }
    }
    static boolean checkSame(int flag, char a, char b){
        if(flag == 0) {
            return a == b;
        }else{
            if(a == 'B' || b == 'B'){
                return a == b;
            }else{
                return true;
            }
        }
    }
}

