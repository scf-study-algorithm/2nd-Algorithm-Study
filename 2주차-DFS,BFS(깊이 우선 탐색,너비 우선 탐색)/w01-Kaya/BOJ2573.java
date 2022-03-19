import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, year, ice;
    static int[][] map, sub;
    static int cnt = 0;
    static int[] dx = {0,0,1,-1};   // 동 서 남 북
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            sub = new int[n][m];
            visited = new boolean[n][m];
            cnt = 0;
            // 영역 세기
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++){
                    if(map[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            if(cnt == 0) {
                System.out.println(0);
                break;
            }
            else if(cnt >= 2) {
                System.out.println(year);
                break;
            }
            // 빙산 녹이기
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++){
                    map[i][j] -= sub[i][j];
                    if(map[i][j] < 0) map[i][j] = 0;
                }
            }

            year++;
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < n && ny >=0 && ny < m) {
                if(map[nx][ny] == 0) {
                    sub[x][y]++;
                }
                if(map[nx][ny] > 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

