package programmers;
//https://programmers.co.kr/learn/courses/30/lessons/43163
import java.util.*;

public class PRO_단어변환 {

    static int answer = 0;
    static boolean[] visited;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        //"hit" -> "hot" -> "dot" -> "dog" -> "cog"

        visited = new boolean[words.length];
        getCount(begin, target, words, 0);


            System.out.println(answer);


    }

    public static void getCount(String begin, String target, String[] words, int cnt){
        if (begin.equals(target)) {
            answer = cnt;
            return; //바로 정답 출력
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) { //이미 방문했을 때
                continue;
            }

            int k = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true;
                getCount(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
