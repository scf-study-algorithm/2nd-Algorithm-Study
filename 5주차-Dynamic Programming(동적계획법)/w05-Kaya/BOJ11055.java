import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n+1];
        int[] d = new int[n+1];

        for(int i=1; i<=n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = a[1];
        for(int i=2; i<=n; i++) {
            d[i] = a[i];
            for(int j=1; j<i; j++) {
                if(a[j] < a[i]) {
                    d[i] = Math.max(d[i], d[j] + a[i]);
                }
            }
        }

        Arrays.sort(d);
        System.out.println(d[n]);
    }
}

