package programmers;
//https://programmers.co.kr/learn/courses/30/lessons/42748
import java.util.*;

public class PRO_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; //i,j,k -> 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
        int[] answer = new int[commands.length];



        for(int i=0; i< commands.length; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();

            for(int j=0; j< array.length; j++){
                if( j  >= commands[i][0]-1 && j <= commands[i][1]-1){
                    list.add(array[j]);
                }
            }

            Collections.sort(list);
            answer[i] = list.get(commands[i][2]-1);
            System.out.println(answer[i]);
        }



    }

}
