import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, target;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        target = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            sb.append(isExist(target[i])).append('\n');
        }

        System.out.println(sb);
    }

    public static int isExist(int k) {
        int lo = 0; int hi = n;

        while(lo < hi) {
            int mid = (lo+hi)/2;

            if(arr[mid] > k) {
                hi = mid;
            } else if(arr[mid] == k) {
                return 1;
            } else {
                lo = mid + 1;
            }
        }

        return 0;
    }
}

