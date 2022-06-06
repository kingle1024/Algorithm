package leetCode;

public class p771 {
    public static int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) return 0;
        int cnt = 0;
        for(int i=0; i<J.length(); i++){
            for(int j=0; j<S.length(); j++){
                if(S.charAt(j) == J.charAt(i))
                    cnt++;  
            }    
        }
        return cnt;
    }
}
