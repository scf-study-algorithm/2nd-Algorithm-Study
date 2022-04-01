import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list);

        int s = 1;
        int e = list.get(list.size() - 1);
        int result = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (isPossible(mid, c, list)) {
                s = mid + 1;
                result = Math.max(mid, result);
            } else {
                e = mid - 1;
            }
        }
        System.out.println(result);
    }

    // 가능한가?
    static boolean isPossible(int d, int c, List<Integer> list) {
        int size = list.size();
        int cnt = 1;
        int machine = list.get(0);
        for (int i = 1; i < size && cnt < c; i++) {
            if (d <= list.get(i) - machine) {
                cnt++;
                machine = list.get(i);
            }
        }
        if (cnt >= c) {
            return true;
        }
        return false;
    }
}
