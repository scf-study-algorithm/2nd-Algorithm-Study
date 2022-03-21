import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int to = commands[i][1];
            int target = commands[i][2];
            
            int[] copyArr = Arrays.copyOfRange(array, start-1, to);
            Arrays.sort(copyArr);
            answer[i] = copyArr[target-1];
        }
        return answer;
    }
}