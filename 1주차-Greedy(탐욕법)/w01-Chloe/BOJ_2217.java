package BOJ;
//https://www.acmicpc.net/problem/2217
import java.util.*;

public class BOJ_2217 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        int[] ropes = new int[N];
        long answer = 0;

        for(int i=0; i<N; i++){
            ropes[i] = in.nextInt();
        }

        Arrays.sort(ropes);
        for(int i = N-1; i >= 0; i--) {
            ropes[i] = ropes[i] * (N-i);
            if(answer < ropes[i]) answer = ropes[i];
        }
        //answer = ropes[0] * N;

        System.out.println(answer);
    }
}
