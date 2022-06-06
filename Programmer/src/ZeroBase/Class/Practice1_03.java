package ZeroBase.Class;

public class Practice1_03 {
    public static void main(String[] args) {
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";
        String replaceStr = "";
        char[] strExArr = replaceStr.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        System.out.println("solution() = " + solution(find.toCharArray(), to.toCharArray(), to.toCharArray()));
    }
    public static String solution(char[] str, char[] find, char[] to){
        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone();
        do{
            idx = findIndex(str, find);

            if(idx != -1){
                for(int i=0; i<idx; i++){
                    replaceStr += replaceBucket[i];
                }
                for(int i=0; i<to.length; i++){
                    replaceStr += to[i];
                }
                for(int i= idx + find.length; i < replaceBucket.length; i++){
                    replaceStr += replaceBucket[i];
                }
                replaceBucket = replaceStr.toCharArray();
                replaceStr = "";
            }
        }while(idx != -1);

        return replaceStr;
    }
    public static int findIndex(char[] str, char[] find){
        int idx = -1;
        boolean isMatch = false;
        for(int i=0; i<str.length; i++){
            if( str[i] == find[0] && find.length <= str.length-i){
                isMatch = true;
                for (int j = 1; j < find.length; j++) {
                    if(str[i+j] != find[j]){
                        isMatch = false;
                        break;
                    }
                }
            }

            if(isMatch){
                idx = i;
                break;
            }
        }
        return idx;
    }
}
