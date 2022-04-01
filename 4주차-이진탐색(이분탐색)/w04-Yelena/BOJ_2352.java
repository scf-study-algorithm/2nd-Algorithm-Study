import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        int[] small = new int[n];
        small[0] = list.get(0);
        int size = 1;
        for(int i = 1; i < n; i++){
            if(small[size-1] > list.get(i)){
                // 더 작은 경우
                int j = size-1;
                for(; j >= 0; j--){
                    if(small[j] < list.get(i)){
                        break;
                    }
                }
                small[j+1] = list.get(i);
            }else{
                // 더 큰 경우
                small[size++] = list.get(i);
            }
        }
        System.out.println(size);
    }
}
