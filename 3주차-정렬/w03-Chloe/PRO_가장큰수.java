package programmers;
//https://programmers.co.kr/learn/courses/30/lessons/42746
import java.util.*;

public class PRO_가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String answer = "";
        String[] nums = new String[numbers.length];

        //변환
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(nums,new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return (o2 +o1).compareTo(o1+o2); //내림차순
            }
                 }
                 );

        if(nums[0].startsWith("0")){
            answer += "0";
        }else{
            for(String s : nums){
                answer += s;
            }
        }

        System.out.println(answer);
    }
}
