import java.util.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        
        long lo = 0; long hi = (long)times[times.length-1]*n;
        
        while(lo < hi) {
            long mid = (lo+hi)/2;
            long can = 0;
            
            for(int i=0; i<times.length; i++) {
                can += (mid/times[i]);
            }
            
            if(can >= n) {
                hi = mid;
                answer = Math.min(answer, mid);
            } else lo = mid+1;
        }
        
        return answer;
    }
}