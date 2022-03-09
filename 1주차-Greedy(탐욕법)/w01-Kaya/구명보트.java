import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.sort(people);
        
        for(int i : people) q.addFirst(i);
        
        while(!q.isEmpty()){
            int weight = q.peekFirst();
            q.pollFirst();
            while(!q.isEmpty() && weight + q.peekLast() <= limit){
                weight += q.peekLast();
                q.pollLast();
            }
            answer++;
        }
        
        return answer;
    }
}