import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] d = new int[1000001];

        d[1] = 1; d[2] = 2;

        for(int i=3; i<=n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 15746;
        }

        System.out.println(d[n]);
    }
}

