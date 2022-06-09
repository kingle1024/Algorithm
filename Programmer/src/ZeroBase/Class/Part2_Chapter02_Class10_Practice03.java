/*
Practice3
데크 변형

입력 예시)
초기 데크 상태 (size: 5)
-> 1, 2, 3, 4
중간 입력 : 10
결과 데크
-> 1, 2, 10, 3, 4
 */
package ZeroBase.Class;
class MyDeque{
    int[] arr;
    int front = 0;
    int rear = 0;
    MyDeque(int size){
        this.arr = new int[size+1];
    }
    public boolean isEmpty(){
        return this.rear == this.front;
    }
    public boolean isFull(){
        return (this.rear +1) % this.arr.length == this.front;
    }
    public void addFirst(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }

        this.arr[front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if(this.isFull()){
            System.out.println("Deque is full!");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }
    public void addMiddle(int data){
        while(true) {
            if ((this.front + 1) % this.arr.length == this.rear + 1 % this.arr.length) {
                System.out.println("hi" + this.front+ " | " + this.rear);
                break;
            }
        }
    }
    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }
    public void printDeque(){
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for(int i = start; i != end; i = (i+1) % this.arr.length){
            System.out.print(this.arr[i] +" ");
        }
        System.out.println();
    }
}
public class Part2_Chapter02_Class10_Practice03 {
    public static void main(String[] args) {
        MyDeque myDeque1 = new MyDeque(5);
        myDeque1.addLast(1);
        myDeque1.addLast(2);
        myDeque1.addLast(3);
        myDeque1.addLast(4);
        myDeque1.printDeque();

        myDeque1.addMiddle(10);
//        myDeque1.printDeque();
    }
}
