import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] arr = new int[v+1][v+1];

        for(int i=1; i<=v; i++) {
            for(int j=1; j<=v; j++) {
                if(i != j) arr[i][j] = INF;
            }
        }

        for(int i=0; i<e; i++) {
            int s = sc.nextInt();
            int f = sc.nextInt();
            int d = sc.nextInt();

            arr[s][f] = d;
        }

        for(int k=1; k<=v; k++) {
            for(int i=1; i<=v; i++) {
                for(int j=1; j<=v; j++) {
                    if(i==j) continue;

                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = INF;
        for(int i=1; i<=v; i++) {
            for(int j=1; j<=v; j++) {
                if(i==j) continue;

                if(arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }

        if(ans == INF) {
            ans = -1;
        }

        System.out.println(ans);
    }
}
