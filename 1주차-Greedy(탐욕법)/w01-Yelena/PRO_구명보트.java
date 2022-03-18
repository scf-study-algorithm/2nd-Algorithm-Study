import java.util.*;

class PRO_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int s = 0; int e = people.length-1;
        while(s <= e){
            int sum = 0;
            // 큰수 
            for(;e >= 0; e--){
                if(sum + people[e] > limit) break;
                sum += people[e];
            }
            // 작은수
            for(;s <= e; s++){
                if(sum + people[s] > limit) break;
                sum += people[s];
            }
            answer++;
        }
        return answer;
    }
}
