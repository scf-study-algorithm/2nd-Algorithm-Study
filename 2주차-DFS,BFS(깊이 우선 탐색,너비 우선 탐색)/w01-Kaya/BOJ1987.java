import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
    static int[] dx = {0,1,0,-1}; // 동 남 서 북
    static int[] dy = {1,0,-1,0};
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[26];

        for(int i=0; i<r; i++) {
            String temp = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        dfs(0,0, 0);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int cnt){
        if(visited[map[x][y]-'A']) {
            ans = Math.max(cnt, ans);
            return;
        }
        visited[map[x][y]-'A'] = true;

        int nx = 0, ny = 0;
        for(int i=0; i<4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >=0 && nx < r && ny >=0 && ny < c) {
                dfs(nx, ny, cnt+1);
            }
        }
        visited[map[x][y]-'A'] = false;
    }
}

