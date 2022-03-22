class PRO_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            answer[i] = getList(commands[i][0],commands[i][1], commands[i][2], array);
        }

        return answer;
    }
    int getList(int s, int e, int k, int[] before){
        int n = e-s+1;
        int idx = 0;
        int[] after = new int[n];

        after[idx] = before[s-1];

        for(int i = s; i < e; i++){
            int num = before[i];
            int j = idx++;
            for(; j >= 0; j--){
                if(num > after[j]) break;
                after[j+1] = after[j];
            }
            after[j+1] = num;
        }

        return after[k-1];
    }
}