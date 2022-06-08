/*
요세푸스 문제
N과 K가 주어졌을 때 (N, K) 요세푸스 순열을 구하시오.
N과 K는 N >= K 를 만족하는 양의 정수이다.
1부터 N까지 N명이 순서대로 원을 이루어 모여 있다.
이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
모든 사람이 제외될 때까지 반복하며 이 때, 제외되는 순서가 요세푸스 순열이다.

예시 입력
입력 : N = 5, K = 2
결과 : 2, 4, 1, 5, 3

입력 : N = 7, K = 3
결과 : 3, 6, 2, 7, 5, 1, 4
 */
package ZeroBase.Class;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Part2_Chapter02_Class08_Practice02 {
    public static ArrayList getJosephusPermutation(int N, int K){
        ArrayList<Integer> array = new ArrayList();
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<N; i++){
            q.add(i+1);
        }

        Queue<Integer> qTemp1 = q;
        Queue<Integer> qTemp2 = new LinkedList();
        int cnt = 1;
        int checkCnt = 0;
        while(true){
            while(true){
                if(cnt == K || qTemp1.peek() == null) break;
//                System.out.println("dk:"+qTemp1.peek());
                qTemp2.add(qTemp1.poll());
                cnt++;
            }
            if(!qTemp1.isEmpty()){
                array.add(qTemp1.poll());
                cnt = 1;
                if(qTemp1.isEmpty() && !qTemp2.isEmpty()){
                    qTemp1 = qTemp2;
                    qTemp2 = new LinkedList();
                }
            }else{
                qTemp1 = qTemp2;
                qTemp2 = new LinkedList();
//                System.out.println("a:"+qTemp1);
//                System.out.println("b:"+qTemp2);
//                System.out.println("c:"+cnt);
            }
            if(qTemp1.isEmpty()) break;
        }
        System.out.println(array);
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getJosephusPermutation(5, 2)); // 2, 4, 1, 5, 3
        System.out.println(getJosephusPermutation(7, 3)); // 3, 6, 2, 7, 5, 1, 4
    }
}
