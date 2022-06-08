package ZeroBase.Class;

// 후위표기법 연산
// 입출력 예시)
// 입력 : "2 2 + "
// 출력 : 4

// 입력: "2 2 -"
// 출력 : 0

import java.util.Stack;

public class Part2_Chapter02_Class06_Practice03 {
    public static double calculate(String string){
        Stack stack = new Stack();
        double result = 0;
        int temp = 0;
        int idx = 2;
        for(String s : string.split(" ")){
            if(s.equals("+")) {
                temp = 0;
                for(int i=0; i<idx; i++) {
                    temp += Integer.parseInt((String) stack.pop());
                }
                stack.add(String.valueOf(temp));
            }else if(s.equals("*")){
                temp = 1;
                for(int i=0; i<idx; i++){
                    temp *= Integer.parseInt((String) stack.pop());
                }
                stack.add(String.valueOf(temp));
            }else if(s.equals("/")){
                int mom = Integer.parseInt((String) stack.pop());
                int son = Integer.parseInt((String) stack.pop());
                temp = son/mom;
                stack.add(String.valueOf(temp));
            }else if(s.equals("-")){
                int cur = Integer.parseInt((String) stack.pop());
                int next = Integer.parseInt((String) stack.pop());
                temp = next - cur;
                stack.add(String.valueOf(temp));
            }else{
                stack.add(s);
            }
        }
        result = Double.parseDouble((String) stack.pop());
        return result;
    }
    public static void main(String[] args) {
        // Test Code
        System.out.println(calculate("2 2 +")); // 4
        System.out.println(calculate("2 2 -")); // 0
        System.out.println(calculate("2 2 *")); // 4
        System.out.println(calculate("2 2 /")); // 1
        System.out.println("=========");
        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -")); // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /")); // 14
        System.out.println(calculate("1 2 3 * +"));
    }
}
