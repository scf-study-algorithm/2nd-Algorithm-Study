import java.util.*;

class PRO_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        Map<Character, Integer> alpha = new HashMap<>();
        init(alpha);

        // 변경
        int move = len-1;
        for(int i = 0; i < len; i++){

            answer += findAlpha(name.charAt(i), alpha);

            int idx = i+1;
            while(idx < len && name.charAt(idx) == 'A'){
                idx++;
            }

            move = Math.min(move, ((i*2) + len-idx));
            move = Math.min(move, (i + ((len-idx)*2)));
        }

        return answer+move;
    }
    void init(Map<Character, Integer> map){
        int idx = 0;
        for(int i = 'A'; i <= 'Z'; i++){
            map.put((char)i, idx++);
        }
    }
    int findAlpha(char des, Map<Character, Integer> map){
        int right = map.get(des) - 0;
        int left = 26 - map.get(des);
        return Math.min(right,left);
    }
}
