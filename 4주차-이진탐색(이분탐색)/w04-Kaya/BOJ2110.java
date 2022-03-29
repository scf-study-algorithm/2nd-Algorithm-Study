import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] map;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n];

        for(int i=0; i<n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(map);

        int lo = 1;
        int hi = map[n-1] - map[0] + 1;

        while(lo < hi) {
            int mid = (lo+hi)/2;

            if(canInstall(mid) < m) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        System.out.println(lo-1);
    }

    public static int canInstall(int dist) {
        int cnt = 1;
        int last = map[0];

        for(int i=1; i<n; i++) {
            if(map[i] - last >= dist) {
                cnt++;
                last = map[i];
            }
        }

        return cnt;
    }
}

