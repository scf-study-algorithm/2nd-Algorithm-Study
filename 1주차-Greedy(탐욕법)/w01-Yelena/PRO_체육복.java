class PRO_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cloth = new int[n];

        for(int i = 0; i < lost.length; i++){
            cloth[lost[i]-1] += (-1);
        }
        for(int i = 0; i < reserve.length; i++){
            cloth[reserve[i]-1] += 1;
        }

        for(int i = 0; i < n; i++){
            if(cloth[i] >= 0){
                answer++;
            }

            if(cloth[i] >= 1){
                // left
                if(i-1 >= 0 && cloth[i-1] == -1){
                    cloth[i-1] += 1;
                    cloth[i] -= 1;
                    answer ++;
                }
                // right
                else if(i+1 < n && cloth[i+1] == -1){
                    cloth[i+1] += 1;
                    cloth[i] -= 1;
                }
            }
        }

        return answer;
    }
}