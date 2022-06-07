package ZeroBase.Class;

// Practice4
// 연결 리스트 사용 연습
// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오.
// 관리 규칙은 다음과 같다.
// 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기

import java.util.ArrayList;
import java.util.HashSet;

public class Part2_Chapter02_Class04_Practice04 {
    public static void dataCollect(String[] data){
        HashSet<Character> hash = new HashSet();
        for(int i=0; i<data.length; i++){
            hash.add(data[i].charAt(0));
        }
        System.out.println(hash);
        Character[] arr = hash.toArray(new Character[0]);
        LinkedList[] linkedList = new LinkedList[hash.size()];
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList(null, arr[i]);
//            System.out.println(arr[i]);
        }

        System.out.println(linkedList[0].alphabet);

        for(int i=0; i<data.length; i++){
            for(int j=0; j<linkedList.length; j++){
                if(linkedList[j].alphabet == data[i].charAt(0)){
//                    System.out.println(data[i]);
                    linkedList[j].addData(data[i]+"");
                }
            }
        }
        for(LinkedList list: linkedList){
            System.out.print(list.alphabet +" : ");
            list.showStrData();
        }
        System.out.println();
//        System.out.println(linkedList[0].head.data);
//        System.out.println(linkedList[1].head.data);
//        System.out.println(linkedList[2].head.data);

    }
    public static void main(String[] args) {
        // Test code
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab"};
        dataCollect(input2);
    }
}
