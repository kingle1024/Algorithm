package ZeroBase.Class;
class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size){
        arr = new int[size];
    }

    public boolean isEmpty(){
        // Test code
        if(this.top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(this.top < arr.length-1)
            return false;
        else
            return true;
    }

    public void push(int data){
        if(this.isFull()){
            System.out.println("Stack is Full!");
            return;
        }
        top+=1;
        this.arr[this.top] = data;
    }

    public Integer pop(){
        if(this.isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        int data = this.arr[this.top];
        this.arr[this.top] = 0;
        this.top-=1;

        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        int data = this.arr[this.top];

        return data;
    }

    public void printStack(){
        for(int i=0; i<=top; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
public class Part2_Chapter02_Class06_02 {
    public static void main(String[] args) {
        MyStack2 myStack = new MyStack2(5);
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.printStack();

        System.out.println(myStack.peek());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();
    }
}
