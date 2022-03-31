import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        long ans = solve();

        System.out.println(ans);
    }

    public static int solve() {
        int lo = 0; int hi = tree[n-1]; // lo를 0부터 해야함 (배열 안의 최소값으로 했다가 틀림 -> 당연함..)
        int res = 0;
        while(lo < hi) {
            long sum = 0;
            int mid = (lo+hi)/2;

            for(int i=0; i<n; i++) {
                if(mid < tree[i]) {
                    sum += (tree[i]-mid);
                }
            }

            if(sum >= m) {
                res = Math.max(res, mid);
                lo = mid+1;
            } else hi = mid;
        }

        return res;
    }
}

