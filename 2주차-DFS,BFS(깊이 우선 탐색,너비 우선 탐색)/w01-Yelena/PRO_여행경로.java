import java.util.*;

class PRO_여행경로 {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];

        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].toString().contentEquals(o2[0].toString())){
                    return o1[1].toString().compareTo(o2[1].toString());
                }else{
                    return o1[0].toString().compareTo(o2[0].toString());
                }
            }
        });

        answer[0] = "ICN";
        dfs(answer[0],1,answer,tickets,visited);
        return answer;
    }
    boolean dfs(String start, int cnt, String[] ans, String[][] tickets, boolean[] visited){

        if(cnt >= ans.length){
            return true;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                ans[cnt] = tickets[i][1];
                if(dfs(ans[cnt],cnt+1,ans,tickets,visited)){
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}