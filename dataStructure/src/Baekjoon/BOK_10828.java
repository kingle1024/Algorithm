package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOK_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        Stack<String> stack = new Stack<>();
        ArrayList<Integer> array = new ArrayList();
        String str;
        for(int i=0; i<num; i++){
            str = bf.readLine();
//            System.out.println(str);
            if(str.indexOf("push") > -1){
                String arr[] = str.split(" ");
                stack.add(arr[1]);
            }else if(str.equals("top")){
                if(stack.empty()){
                    array.add(Integer.parseInt("-1"));
                    System.out.println(Integer.parseInt("-1"));
                }else{
                    String topStr = stack.pop();
                    array.add(Integer.parseInt(topStr));
                    System.out.println(Integer.parseInt(topStr));
                    stack.add(topStr);
                }
            }else if(str.equals("size")){
                array.add(stack.size());
                System.out.println(stack.size());
            }else if(str.equals("empty")){
                if(stack.empty()){
                    array.add(1);
                    System.out.println("1");
                }else{
                    array.add(0);
                    System.out.println("0");
                }
            }else if(str.equals("pop")){
                if(stack.empty()){
                    array.add(-1);
                    System.out.println("-1");
                }else{
                    String popStr = stack.pop();
                    array.add(Integer.parseInt(popStr));
                    System.out.println(Integer.parseInt(popStr));
                }
            }
        }
//        for(int i=0; i<array.size(); i++){
//            System.out.println(array.get(i));
//        }
    }

}
