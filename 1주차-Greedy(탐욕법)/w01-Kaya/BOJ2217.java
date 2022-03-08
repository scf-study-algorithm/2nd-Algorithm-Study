import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];

        for(int i=0; i<n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int ans = 0; int cnt = 1;
        for(int i=n-1; i>=0; i--){
            ans = Math.max(ans, rope[i] * cnt);
            cnt++;
        }

        System.out.println(ans);
    }
}

