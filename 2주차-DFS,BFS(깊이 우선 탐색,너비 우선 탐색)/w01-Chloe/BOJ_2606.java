package BOJ;
//https://www.acmicpc.net/problem/2606
import java.util.*;

public class BOJ_2606 {

    static int[][] network;
    static boolean[] visited;
    static int N,M,V;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        //V=1;
    network = new int[N+1][N+1];// 각 정점간 탐색 경로를 저장할 배열
        visited = new boolean[N+1]; //탐색 여부 체크

        for(int i=0; i<M; i++){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
          network[num1][num2] = network[num2][num1] = 1;
        }



        System.out.println(dfs(1));

    }

    public static int dfs(int i){
        visited[i] = true;
        for(int j=1; j<=N; j++) {
            if(network[i][j] == 1 && visited[j] == false) {
                answer ++;
                dfs(j);
            }
        }
        return answer;
    }
}
