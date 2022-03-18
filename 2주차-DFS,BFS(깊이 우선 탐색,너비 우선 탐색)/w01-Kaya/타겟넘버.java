class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs('+', numbers, target, 0, 0);
        dfs('-', numbers, target, 0, 0);
        
        answer = cnt;
        return answer;
    }
    
    public static void dfs(char symbol, int[] numbers, int target, int depth, int sum) {
        if(symbol == '+') {
            sum += numbers[depth];
        } else {
            sum -= numbers[depth];
        }
        if(depth == numbers.length-1) {
            if(sum == target) cnt++;
            return;
        }

        dfs('+', numbers, target, depth+1, sum);
        dfs('-', numbers, target, depth+1, sum);
    }
}