import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int[][] score;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            score = new int[n][2];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }

            // 배열을 정렬
            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            // 제일 첫번째 원소는 무조건 뽑힘(서류 1등이므로)
            int cnt = 1;
            int comp = score[0][1];   // 서류 1등의 면접 순위를 기준으로 (서류가 뒤쳐지는 사람들은 이 면접 순위보다 높아야 함)
            for(int i=1; i<n; i++) {
                if(comp > score[i][1]) {  // 기준보다 높은 사람 발견 -> 그 사람을 다시 기준으로 삼음 (다음 사람은 이 순위보다 높아야 뽑히니까)
                    cnt++;
                    comp = score[i][1];
                }
            }

            System.out.println(cnt);
        }
    }
}

