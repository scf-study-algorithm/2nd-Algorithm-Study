package BOJ;
//https://www.acmicpc.net/problem/1956
import java.util.*;



public class BOJ_1956 {
    public static int V,E;
    public static int[][] map;
    public static int answer = 0;
    public static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        V = in.nextInt();
        E = in.nextInt();

        map = new int[V+1][V+1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        for(int i=0; i<E; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            map[a][b] = c;
        }



        // 플로이드 와샬 알고리즘 수행
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        answer = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }

                // 자기 자신을 제외한 두 정점이
                // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
                if (map[i][j] != INF && map[j][i] != INF) {
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }
            }
        }

        // answer가  초기값이면 사이클이 존재하지 않음.
        answer = (answer == INF) ? -1 : answer;

    System.out.println(answer);

    }

}
