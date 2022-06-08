package ZeroBase.Class;

class MyDeque2{
    int point = 0;
    int[] arr;
    MyDeque2(int size){
        arr = new int[size];
    }
    public boolean isEmpty(){
        if(point == -1){
            return true;
        }else{
            return false;
        }
    }
    public boolean isFull(){

        return false;
    }
    public void addFirst(int data){
        if(point == 0){
            arr[0] = data;
        }else if(point == arr.length){
            System.out.println("Deque is Full");
            return;
        }else {
            for (int i = point-1; i >= 0; i--) {
//                System.out.println("hi");
                arr[i+1] = arr[i];
            }
            arr[0] = data;
        }
        point++;
    }
    public void addLast(int data){
        if(point == arr.length){
            System.out.println("Deque is Full");
            return;
        }
        arr[point] = data;
        point++;
    }
    public Integer removeFirst(){
        if(isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }
        int data = arr[0];
        for(int i = 1; i<point; i++){
            arr[i-1] = arr[i];
        }
        point--;
        return data;
    }

    public Integer removeLast(){
        if(isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }
        int data = arr[point];
        point--;
        return data;
    }


    public void printDeque(){
        for(int i=0; i<point; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
public class Part2_Chapter02_Class10_03 {
    public static void main(String[] args) {
        MyDeque2 myDeque = new MyDeque2(5);
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.printDeque(); // 3 2 1

        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addLast(30); // Deque is full!
        myDeque.printDeque(); // 3 2 1 10 20

        System.out.println(myDeque.removeFirst()); // 3
        myDeque.printDeque(); // 2 1 10 20

        System.out.println(myDeque.removeLast()); // 20
        myDeque.printDeque(); // 2 1 10

        System.out.println(myDeque.removeLast()); // 10
//        System.out.println(myDeque.removeLast()); // 1
//        System.out.println(myDeque.removeLast()); // 2
//        System.out.println(myDeque.removeLast()); // Deque is empty!

    }
}

