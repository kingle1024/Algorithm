package ZeroBase.Class;

import java.util.ArrayList;

class MyStack1{
    ArrayList list;
    MyStack1(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if(this.list.size() != 0){
            return false;
        }
        return true;
    }
    public void push(int data){
        list.add(data);
    }

    public Integer pop(){
        if(this.isEmpty()){
            return null;
        }
        int data = (int) this.list.get(this.list.size() -1);
        this.list.remove(this.list.size()-1);
        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            return null;
        }
        int data = (int) this.list.get(this.list.size()-1);
        return data;
    }

    public void printStack(){
        for(int i=0; i<this.list.size(); i++){
            System.out.print(this.list.get(i)+" ");
        }
        System.out.println();
    }
}
public class Part2_Chapter02_Class06 {
    public static void main(String[] args) {
        // Test code
        MyStack1 myStack = new MyStack1();
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.printStack();

        System.out.println(myStack.peek());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack(); // 1, 2, 3

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();

    }
}
