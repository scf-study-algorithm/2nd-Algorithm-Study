package BOJ;
//https://www.acmicpc.net/problem/2437
import java.util.*;

public class BOJ_2437 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int answer = 0;

        for(int i=0; i<N; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for(int j=0; j<N; j++){

            if (answer + 1 < arr[j]) {
                break;
            }


            answer += arr[j];
        }

        System.out.println(answer+1);
    }
}
