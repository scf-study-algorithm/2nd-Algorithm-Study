package programmers;
//https://programmers.co.kr/learn/courses/30/lessons/43165
import java.util.*;

public class PRO_타겟넘버 {
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        dfs(numbers, target, 0);

        System.out.println(answer);

    }

    public static void dfs(int[] numbers, int target, int index){
        if(index == numbers.length){
            //return answer;
            int sum =0;
            for(int i=0; i<numbers.length; i++){
                sum += numbers[i];
            }
            if(sum == target){
                answer++;
            }
        }else{
            numbers[index] *= 1;
            dfs(numbers, target, index+1);

            numbers[index] *= -1;
            dfs(numbers, target, index+1);
        }

    }
}
