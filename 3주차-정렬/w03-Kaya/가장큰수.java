import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] result = new String[numbers.length];
        
        int cnt = 0;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 0) cnt++;
            result[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        for(int i=0; i<result.length; i++) {
            answer += result[i];
        }
        
        if(cnt == numbers.length) answer = "0";
        return answer;
    }
}