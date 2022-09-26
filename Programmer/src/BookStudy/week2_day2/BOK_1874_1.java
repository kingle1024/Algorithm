package BookStudy.week2_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOK_1874_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        int idx = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        while(true){
            int num = arr[cnt];
            if(stack.isEmpty() || stack.peek() <= num){
                while(true) {
                    if(num < idx) break;
                    stack.push(idx);
                    idx++;
                    //                    System.out.println("+");
                    sb.append("+\n");
                }
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                //                System.out.println("-");
                sb.append("-\n");
            }else{
                while(!stack.isEmpty()) {
                    if(stack.peek() < num) break;
                    stack.pop();
                    //                    System.out.println("-");
                    sb.append("-\n");
                }
            }
            cnt++;
            if(cnt >= N) break;
        }
        if(stack.size() == 0) {
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
        }
    }
}
