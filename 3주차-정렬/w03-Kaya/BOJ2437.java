import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int sum = 0;
        for(int i=0; i<n; i++){
            if(sum+1 < nums[i]) { // 누적합까지의 무게는 무조건 만들 수 있다. 따라서 누적합+1 보다 큰 수가 뒤에 오면 누적합+1을 만들 수 없으므로 정답이 누적합+1이 된다.
                break;
            }
            sum += nums[i];
        }

        System.out.println(sum+1);
    }
}

