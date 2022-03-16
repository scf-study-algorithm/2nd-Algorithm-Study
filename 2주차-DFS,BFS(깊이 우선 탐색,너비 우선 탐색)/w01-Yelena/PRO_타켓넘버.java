class PRO_타켓넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(0,0,numbers,target);
    }
    int dfs(int idx, int sum, int[] number, int target){
        if(idx >= number.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        int cnt = 0;

        cnt += dfs(idx+1,sum+number[idx],number,target);
        cnt += dfs(idx+1,sum-number[idx],number,target);

        return cnt;
    }
}
