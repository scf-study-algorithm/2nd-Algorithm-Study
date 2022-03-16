import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> allRoute = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        
        dfs(cnt, "ICN", "ICN", tickets);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public static void dfs(int cnt, String start, String route, String[][] tickets) {
        if(cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(cnt+1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}