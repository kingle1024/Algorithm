package ZeroBase.Class;

import java.util.ArrayList;

class MyDeque1{
    ArrayList list;

    MyDeque1(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if(list.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void addFirst(int data){
        list.add(0, data);
    }
    public void addLast(int data){
        list.add(list.size(), data);
    }
    public Integer removeFirst(){
        if(isEmpty()){
            System.out.println("list is Empty");
            return null;
        }
        int data = (int) list.get(0);
        list.remove(0);
        return data;
    }
    public Integer removeLast(){
        if(isEmpty()){
            System.out.println("list is Empty");
            return null;
        }
        int data = (int) list.get(list.size()-1);
        list.remove(list.size()-1);
        return data;
    }

    public void printDeque(){
        System.out.println(list);
    }
}
public class Part2_Chapter02_Class10_02 {
    public static void main(String[] args) {
        MyDeque1 myDeque = new MyDeque1();
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.printDeque(); // 3 2 1

        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addLast(30);
        myDeque.printDeque(); // 3 2 1

        System.out.println(myDeque.removeFirst()); // 3
        myDeque.printDeque(); // 2 1 10 20 30

        System.out.println(myDeque.removeLast()); // 30
        myDeque.printDeque(); // 2 1 10 20

        System.out.println(myDeque.removeLast()); // 20
        System.out.println(myDeque.removeLast()); // 10
        System.out.println(myDeque.removeLast()); // 1
        System.out.println(myDeque.removeLast()); // 2
        myDeque.printDeque();

    }
}
