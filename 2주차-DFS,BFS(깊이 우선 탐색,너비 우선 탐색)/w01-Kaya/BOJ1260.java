import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] ad;
    static boolean[] visited;
    static int n, m, v;
    static String route = "";
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        ad = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ad[x][y] = 1;
            ad[y][x] = 1;
        }

        dfs(v);
        System.out.println(route);

        route = "";
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(route);
    }

    public static void dfs(int x){
        visited[x] = true;
        route += Integer.toString(x) + " ";
        for(int i=1; i<=n; i++) {
            if(ad[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int x) {
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            route += Integer.toString(now) + " ";
            for(int i=1; i<=n; i++) {
                if(ad[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

