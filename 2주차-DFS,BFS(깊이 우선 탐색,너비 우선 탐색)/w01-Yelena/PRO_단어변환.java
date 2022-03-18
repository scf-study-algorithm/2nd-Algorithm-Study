import java.util.*;

class PRO_단어변환 {
    public int solution(String begin, String target, String[] words) {
        int sz = words.length;

        boolean[] visited = new boolean[sz];
        Queue<String> w = new LinkedList<>();
        Queue<Integer> cnt = new LinkedList<>();

        w.add(begin);
        cnt.add(0);

        while(!w.isEmpty()){

            String cur = w.poll();
            int curCnt = cnt.poll();

            for(int i = 0; i < sz; i++){
                if(!visited[i] && check(cur,words[i])){
                    visited[i] = true;
                    if(words[i].equals(target)){
                        return curCnt + 1;
                    }
                    w.add(words[i]);
                    cnt.add(curCnt+1);
                }
            }
        }
        return 0;
    }

    boolean check(String a , String b){
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
            if(cnt >= 2){
                return false;
            }
        }
        return true;
    }
}