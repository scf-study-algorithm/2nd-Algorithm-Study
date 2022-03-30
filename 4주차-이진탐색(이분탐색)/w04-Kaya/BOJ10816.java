import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] card;
    static int[] target;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        card = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);  // 이분 탐색은 정렬을 해야함

        m = Integer.parseInt(br.readLine());
        target = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            sb.append(findCard(target[i])).append(" ");
        }
        sb.append('\n');

        System.out.println(sb);
    }

    public static int findCard(int k) {
        int b1 = lowerBound(k);
        int b2 = upperBound(k);

        return b2-b1;
    }

    public static int lowerBound(int k) {
        int lo = 0; int hi = n;
        // card[0] ~ card[n-1]보다 큰 숫자를 찾을 때 결과값은 n일 것이기 때문에 hi를 n으로 둔다.

        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(card[mid] >= k) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int upperBound(int k) {
        int lo = 0; int hi = n;
        // card[0] ~ card[n-1]보다 큰 숫자를 찾을 때 결과값은 n일 것이기 때문에 hi를 n으로 둔다.

        while(lo < hi) {
            int mid = (lo+hi)/2;

            if(card[mid] > k) {
                hi = mid;
            } else lo = mid+1;
        }

        return lo;
    }
}

