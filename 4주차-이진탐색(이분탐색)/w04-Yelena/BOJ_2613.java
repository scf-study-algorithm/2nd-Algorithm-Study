import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int[] count = new int[m];

        // input
        st = new StringTokenizer(br.readLine());
        int s = 0, e = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            if(s < num){
                s = num;
            }
            e += num;
        }

        // 최소 합 구하기
        int min = e;
        while(s <= e){
            int mid = (s+e)/2;

            if(isPossible(n,m,mid,list)){
                System.out.println(mid);
                e = mid - 1;
                min = Math.min(mid,min);
            }else{
                s = mid + 1;
            }
        }

        count = getCount(n,m,min,list);

        // output
        StringBuilder sb = new StringBuilder();
        sb.append(min+"\n");
        for (int c : count) {
            sb.append(c + " ");
        }
        System.out.println(sb);
    }
    static boolean isPossible(int n, int m, int limit, List<Integer> l){
        int cnt = 1, sum = l.get(0);
        for(int i = 1; i < n; i++){
            if(sum + l.get(i) > limit){
                cnt++;
                sum = l.get(i);
            }else{
                sum += l.get(i);
            }
        }

        return (cnt <= m);
    }
    static int[] getCount(int n, int m, int total, List<Integer> l){

        int idx = 0, sum = l.get(0);
        int[] result = new int[m];
        result[idx]++;

        for(int i = 1; i < n; i++){
            if(idx+1+(n-i) > m && sum + l.get(i) <= total){
                result[idx]++;
                sum += l.get(i);
            }else{
                sum = l.get(i);
                result[++idx]++;
            }
        }
        return result;
    }
}
