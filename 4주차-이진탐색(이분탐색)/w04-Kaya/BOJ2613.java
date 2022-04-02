import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] ball;
    static int[] group;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ball = new int[n];
        group = new int[m];

        int lo = 0; int hi = n*100;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            ball[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, ball[i]);
        }

        while(lo <= hi) {
            int mid = (lo+hi)/2;

            if(isPossible(mid)) {
                hi = mid - 1;
            } else lo = mid + 1;
        }

        // 출력부
        System.out.println(lo);
        int sum = 0; int cnt = 0;
        for(int i=0; i<n; i++) {
            sum += ball[i];
            if(sum > lo) {
                sum = ball[i];
                m--;
                System.out.printf("%d ", cnt);
                cnt = 0;
            }
            cnt++;

            // 그룹마다 구슬 1개씩 남겨놓기 위해
            if(n - i == m) break;
        }

        while(m-- > 0) {
            System.out.println(cnt);
            cnt = 1;
        }
    }

    public static boolean isPossible(int k) {     // k라는 값(답으로 찾을 값)으로 그룹 지었을 때 그룹 개수가 얼마나 나오는지 세는 함수
        int cnt = 1;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += ball[i];
            if(sum > k) {
                sum = ball[i];
                cnt++;
            }
        }

        return cnt <= m;
    }
}

