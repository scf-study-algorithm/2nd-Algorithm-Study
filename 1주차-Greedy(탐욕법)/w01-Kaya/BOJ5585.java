import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coin = {500,100,50,10,5,1};
        N = 1000-N;

        int ans = 0;
        for(int c: coin){
            ans += N/c;
            N %= c;
        }

        System.out.println(ans);
    }
}

