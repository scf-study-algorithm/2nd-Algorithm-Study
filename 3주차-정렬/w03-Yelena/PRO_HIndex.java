import java.util.*;

class PRO_HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        // n편 중 h번 이상 인용 논문이 h이상
        Arrays.sort(citations);

        for(int i = 0; i < len; i++){
            int cnt = len - i;
            if(citations[i] >= cnt){
                return cnt;
            }
        }

        return 0;
    }
}
