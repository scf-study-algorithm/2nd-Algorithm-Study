import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            // sort
            Collections.sort(list);

            // calculate
            int answer = 0;
            int num = list.get(0);
            for(int i = 2; i < n; i+=2){
                answer = compareNum(answer,num,list.get(i));
                num = list.get(i);
            }
            int i = (n%2 == 0) ? n-1:n-2;
            for(; i >= 0; i-=2){
                answer = compareNum(answer,num, list.get(i));
                num = list.get(i);
            }
            answer = compareNum(answer,list.get(0),list.get(1));
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
    static int compareNum(int answer, int num1, int num2){
        int gap = Math.abs(num1-num2);
        return Math.max(answer,gap);
    }
}