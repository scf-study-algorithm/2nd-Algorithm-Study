package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1946_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());	// 지원자 숫자
            int[][] arr = new int[N][2];	// 각 지원자의 서류, 면접 성적
            int count = 1;			// 정렬의 첫 번째 사람은 자동 채용
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 정렬 - Comparator
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {	// 서류를 기준으로 오름차순 정렬을 시행한다.
                    return Integer.compare(arr1[0], arr2[0]);
                }
            });

            int pivot = arr[0][1];	// 첫 번째 지원자의 면접 성적이 기준이 된다.
            for(int i=1; i<N; i++) {
                if(arr[i][1] < pivot) {	// 면접 성적이 그 전 선발된 지원자 보다 뛰어날경우 => 선발
                    pivot = arr[i][1];	// 다음 합격자를 판별하기 위해 전에 선발된 지원자의 면접 성적 저장
                    count ++;
                }
            }

            sb.append(count);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
