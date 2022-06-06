import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOK_1874 {
    public static void main(String[] args) {
        solution();
    }
    static void solution(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = num-1; i>=0; i--){
            stack.add(arr[i]);
        }

        ArrayList<String> array = new ArrayList<>();

        int idx = 0;
        int preNum = 0;
        int maxNum = 1;
        int popNum = 0;
        while (true) {
            boolean check = false;
            if(stack.empty()) break;
            // 넣는 경우
            popNum = stack.pop();
            for(int i=maxNum; i<=popNum; i++){
                array.add("+");
                if(i == popNum){ // 해당하는 숫자를 빼줌
                    array.add("-");
                }
                check = true;
            }
            if(!check) stack.add(popNum);

            // 다음 넣는 경우를 위해서 처리해주는 부분
            if(maxNum < popNum) maxNum = popNum +1;

            if(stack.empty()) break;
            // 빼는 경우
            int popNum2 = stack.pop();
            if(popNum >= popNum2){
                array.add("-");
            }else{
                stack.add(popNum2);
            }
        }
        for(int i=0; i< array.size(); i++){
            System.out.println(array.get(i));
        }
    }
}
