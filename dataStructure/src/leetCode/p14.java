package leetCode;

public class p14 {
	public static void main(String[] args) {
		String strs[] = {"dog","racecar","car"};
		
		System.out.println(longestCommonPrefix(strs).toString());
	}
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) return "";
    	else if(strs.length ==1) return strs[0];
    	String result = "";
    	char check;
    	boolean missCheck = false;
    	int min = strs[0].length();
    	for(int i=1; i<strs.length; i++){
    		if(min > strs[i].length())
    			min = strs[i].length();
    	}
        for(int i=0; i < min; i++){
        	missCheck = false;
        	check = strs[0].charAt(i);
        	for(int j=1; j<strs.length; j++){
        		if(check != strs[j].charAt(i)){
        			missCheck = true;
        		}
        	}
        	if(missCheck) break;
        	result += check;
        }
        return result;
    }
}
