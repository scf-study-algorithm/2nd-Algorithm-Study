class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int length = number.length() - k;
        int idx = 0; int end = 0;
        int comp = 0;
        end = number.length() - (length - 1);
        for(int i=1; i<=length; i++){
            comp = 0;
            for(int j=idx; j<end; j++){
                if(comp < number.charAt(j)-'0'){
                    comp = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(comp);
            end++;
        }
        
        return answer.toString();
    }
}