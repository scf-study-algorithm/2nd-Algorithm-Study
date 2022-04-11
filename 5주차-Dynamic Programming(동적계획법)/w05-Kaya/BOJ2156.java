import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n+1];
        int[] d = new int[n+1];

        for(int i=1; i<=n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        d[1] = w[1];

        if(n>1) {
            d[2] = w[1]+w[2];
        }
        for(int i=3; i<=n; i++) {
            d[i] = Math.max(d[i-1], Math.max(d[i-2] + w[i], d[i-3] + w[i-1] +w[i]));
        }

        System.out.println(d[n]);
    }
}

