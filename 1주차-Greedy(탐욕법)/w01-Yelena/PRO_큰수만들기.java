class PRO_큰수만들기 {
    public String solution(String number, int k) {
        int len = number.length();
        int s = 0, e = k, n = 0;
        int[] tmp = new int[len-k];
        int[] num = StringToInt(number);
        while(n < len-k){
            for(int i = s; i <= e; i++){
                if(num[i] > tmp[n]){
                    tmp[n] = num[i];
                    s = i+1;
                }
            }
            n++;
            e++;
        }

        return IntToString(tmp);
    }
    int[] StringToInt(String number){
        int[] num = new int[number.length()];
        for(int i = 0; i < number.length(); i++){
            num[i] = Integer.parseInt(number.substring(i,i+1));
        }
        return num;
    }
    String IntToString(int[] tmp){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tmp.length; i++){
            sb.append(Integer.toString(tmp[i]));
        }
        return sb.toString();
    }
}
