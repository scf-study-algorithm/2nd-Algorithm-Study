import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int n, ans;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited[1] = true;
        for(int i=1; i<=n; i++){
            if(graph[1][i] == 1) {
                dfs(i);
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int x) {
        if(!visited[x]) {
            visited[x] = true;
            ans++;
            for(int i=1; i<=n; i++) {
                if(graph[x][i] == 1 && !visited[i]) {
                    dfs(i);
                }
            }
        }
    }
}

