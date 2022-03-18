import java.util.*;

class PRO_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // init
        boolean[] visited = new boolean[n];
        List<Integer>[] list = new List[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        // connect
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    list[i].add(j);
                }
            }
        }

        // output
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, visited,list);
                answer++;
            }
        }

        return answer;
    }
    void bfs(int n, boolean[] visited, List<Integer>[] list){

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()){
            int idx = q.poll();

            for(int i = 0; i < list[idx].size(); i++){
                if(!visited[list[idx].get(i)]){
                    visited[list[idx].get(i)] = true;
                    q.add(list[idx].get(i));
                }
            }
        }
    }
}
