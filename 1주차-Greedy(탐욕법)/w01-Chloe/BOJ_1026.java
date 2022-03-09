package BOJ;
//https://www.acmicpc.net/problem/1026
import java.util.*;

public class BOJ_1026 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            A[i] = in.nextInt();
        }

        for(int j=0; j<N; j++){
            B[j] = in.nextInt();
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        for(int k=0; k<N; k++){
            answer += A[k]*B[k];
        }

        System.out.println(answer);

    }
}
