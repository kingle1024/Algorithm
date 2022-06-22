package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BOK_8892 {
    public static void main(String[] args) {
        solution();
    }
    static void solution(){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList> totalArray = new ArrayList<>();
        int T = sc.nextInt();
        int k;
        for(int i=0; i<T; i++){
            k = sc.nextInt();
            ArrayList<String> array = new ArrayList<>();
            for(int j=0; j<k; j++){
                array.add(sc.next());
            }
            totalArray.add(array);
        }


        for(int i=0; i<totalArray.size(); i++){
            boolean isPalindrome = false;
            for(int j=0; j<totalArray.get(i).size()-1; j++){
                for(int z=j+1; z<totalArray.get(i).size(); z++){
                    StringBuffer sb = new StringBuffer();
                    sb.append(totalArray.get(i).get(j));
                    sb.append(totalArray.get(i).get(z));
                    if(palindrome(String.valueOf(sb))){
                        System.out.println(String.valueOf(sb));
                        isPalindrome = true;
                        break;
                    }
                    sb = new StringBuffer();
                    sb.append(totalArray.get(i).get(z));
                    sb.append(totalArray.get(i).get(j));
                    if(palindrome(String.valueOf(sb))){
                        System.out.println(String.valueOf(sb));
                        isPalindrome = true;
                        break;
                    }
                }
                if(isPalindrome) {
                    break;
                }
            }
            if(!isPalindrome){
                System.out.println("0");
            }
        }
    }
    static boolean palindrome(String s){
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
