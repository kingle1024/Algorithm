package ZeroBase.Class;

class MyQueue2{
    int[] arr;
    int front = 0;
    int rear = 0;
    MyQueue2(int size){
        arr = new int[size+1];
    }
    public boolean isEmpty(){
        int f = this.front % this.arr.length;
        int r = this.rear % this.arr.length;
        return r == f;
    }
    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(this.rear != 0) {
            arr[this.rear % (this.arr.length)] = data;
        }else{
            arr[this.rear] = data;
        }

        rear++;
//        this.rear = (this.rear + 1) % this.arr.length;
//        this.arr[this.rear] = data;
    }
    public Integer dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return null;
        }
        int data = front;
        front = (front+1) % arr.length;
        return arr[data];
    }
    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return;
        }
        int f = front % arr.length;
        int r = rear % arr.length;
        if(f > r){
            for(int i=f; i<arr.length; i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=0; i<r; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=f; i<r; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public void printArr(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
public class Part2_Chapter02_Class08_03 {
    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6); // Queue is Full

        myQueue.printQueue();// 1, 2, 3, 4, 5

        System.out.println(myQueue.dequeue()); // 1
        myQueue.printQueue(); // 2, 3, 4, 5

        System.out.println(myQueue.dequeue()); // 2
        myQueue.printQueue(); // 3, 4, 5

        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.printQueue(); // 3, 4, 5, 6, 7

        System.out.println(myQueue.dequeue()); // 3
        System.out.println(myQueue.dequeue()); // 4
        System.out.println(myQueue.dequeue()); // 5
        myQueue.printQueue(); // 6, 7
        System.out.println(myQueue.dequeue()); // 6
        System.out.println(myQueue.dequeue()); // 7
        myQueue.dequeue();

    }
}
