package BOJ;
//https://www.acmicpc.net/problem/2959
import java.util.*;

public class BOJ_2959 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] points = new int[4];

        for(int i=0; i<4; i++){
            points[i] = in.nextInt();
        }

        Arrays.sort(points);

        int answer = points[0] * points[2];

        System.out.println(answer);
    }
}
