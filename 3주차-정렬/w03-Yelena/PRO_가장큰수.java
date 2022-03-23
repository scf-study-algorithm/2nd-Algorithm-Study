import java.util.*;

class PRO_가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(num, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                StringBuilder str1 = new StringBuilder(o1.toString());
                StringBuilder str2 = new StringBuilder(o2.toString());
                String s1 = "0", s2 = "0";

                while(str1.length() < 4){
                    str1.append(str1);
                    if(str1.length() > 4){
                        s1 = str1.substring(0,4);
                    }
                }

                while(str2.length() < 4){
                    str2.append(str2);
                    if(str2.length() > 4){
                        s2 = str2.substring(0,4);
                    }
                }

                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                return n1-n2;
            }
        });

        boolean flag = true;
        for(int i = num.length-1; i >= 0; i--){
            if(flag && num[i] != 0) flag = false;
            answer.append(num[i]);
        }

        if(flag == true){
            return "0";
        }
        return answer.toString();
    }
}