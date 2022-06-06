package leetCode;

import java.util.Stack;

public class p922 {
	public int[] sortArrayByParityII(int[] A) {
        Stack<Integer> odd = new Stack<Integer>();
        Stack<Integer> even = new Stack<Integer>();
        
        for(int i=0; i<A.length; i++){
            if(A[i] %2 == 0){
                even.push(A[i]);
            }else{
                odd.push(A[i]);
            }
        }
        for(int i=0; i<A.length; i++){
            if(i%2 ==0)
                A[i] = even.pop();
            else
                A[i] = odd.pop();
        }
        return A;
    }
}
