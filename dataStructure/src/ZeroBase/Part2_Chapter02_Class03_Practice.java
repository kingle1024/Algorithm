// Practice
// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.sql.SQLOutput;
import java.util.Arrays;

class MyArray{
    int[] arr;
    // 배열의 초기 사이즈 설정
    MyArray(int size){
        arr = new int[size];
    }
    void insertData(int num, int data){
        if(num < 0 || num > this.arr.length){
            System.out.println("Index Error");
            return;
        }
        int[] arrDup = new int[arr.length+1];

        for(int i=0; i<num; i++){
            arrDup[i] = arr[i];
        }
        for(int i = num; i<arr.length; i++){
            arrDup[i+1] = arr[i];
        }
        arrDup[num] = data;
        arr = arrDup;
    }
    // 배열에 데이터 삽입

    // 배열에서 특정 데이터 삭제
    void removeData(int idx){
        if(idx < 0 || idx > this.arr.length){
            System.out.println("Index Error");
            return;
        }
        int[] arrDup = new int[arr.length-1];
        for(int i=0; i<idx; i++){
            arrDup[i] = arr[i];
        }
        for(int i = idx; i<arr.length-1; i++){
            arrDup[i] = arr[i+1];
        }
        arr = arrDup;
    }
    void removeTargetData(int data){
        int targetData = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == data){
                targetData = i;
            }
        }
        int[] arrDup = arr.clone();
        arrDup = new int[arr.length-1];
        if(targetData == -1){
            System.out.println("찾는 데이터가 없습니다.");
            return;
        }else{
            System.out.println(targetData);
            for(int i=0; i<targetData; i++){
                arrDup[i] = arr[i];
            }
            for(int i=targetData; i<arr.length-1; i++){
                arrDup[i] = arr[i+1];
            }
            arr = arrDup;
        }
    }
}
public class Part2_Chapter02_Class03_Practice {
    public static void main(String[] args) {
        // Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for(int i=0; i<size; i++){
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));
//
//        myArray.insrtData(6, 20);
        myArray.removeTargetData(2);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(99);
    }
}
