import java.util.Scanner;
import java.util.Stack;

public class BOK_9012 {
    //    BOK_9012
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String arr[] = new String[num];
        for(int i=0; i<num; i++){
            arr[i] = solution(sc.next());
        }
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i]);
        }
    }
    static String solution(String s){
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add("(");
            }else{
                if(!stack.empty()){
                    stack.pop();
                }else{
                    return "NO";
                }
            }
        }
        if(stack.size() > 0) return "NO";
        return "YES";
    }
}
