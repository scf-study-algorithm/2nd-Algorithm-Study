package BOJ;
//https://www.acmicpc.net/problem/5585
import java.util.*;

public class BOJ_5585 {
    public static void main(String[] args) {
        //500엔, 100엔, 50엔, 10엔, 5엔, 1엔
        Scanner in= new Scanner(System.in);
        int cost = in.nextInt();
        int[] coinArr = {500, 100, 50, 10, 5, 1};
        cost = 1000 - cost;
        int answer = 0;
        for(int i=0; i<6; i++){
            if(cost/coinArr[i]>0){
                answer += cost/coinArr[i];
                cost = cost%coinArr[i];
            }
        }

        System.out.println(answer);
    }
}
