package ZeroBase.Class;

class NodeBi{
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}
class DoublyLinkedList extends LinkedList{
    NodeBi head;
    NodeBi tail;
    DoublyLinkedList(NodeBi node){
        this.head = node;
        this.tail = node;
    }
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData){
        if(this.head == null){
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        }else if (beforeData == null){ // 가장 끝에 추가하는 경우
            this.tail.next = new NodeBi(data, null, this.tail);
            this.tail = this.tail.next;
        }else{
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while(cur != null){
                if(cur.data == beforeData){
                    if(cur == this.head){ // 한개밖에 없는 경우
                        this.head = new NodeBi(data, this.head, null);
                        this.head.next.prev = this.head;
                    }else{ // 중간에 추가되는 경우
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        NodeBi cur = this.head;
        NodeBi prev = cur;
        while(cur != null){
            if(cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) { // 맨 앞에 있는 숫자 제거
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail) { // 가장 뒤에 있는 숫자 제거
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
//                    prev.next = this.head;
//                    this.head.next.prev = prev.next;
                    prev.next = cur.next;
                    cur.next.prev = prev;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        NodeBi cur = this.head;
        while(cur != null){
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void showDataFromTail(){
        if(this.isEmpty()){
            System.out.println("List is Empty!");
            return;
        }

        NodeBi cur = this.tail;
        while(cur != null){
            System.out.print(cur.data +" ");
            cur = cur.prev;
        }
        System.out.println();
    }
}

public class Part2_Chapter02_Class04_02 {
    public static void main(String[] args) {
        // Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.removeData(3);
        myList.showData(); // 1 2 3 4 5
        myList.showDataFromTail(); // 5 4 3 2 1

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData(); // 100 1 200 2 300 3 400 4 500 5
        myList.showDataFromTail(); // 5 500 4 400 3 300 2 200 1 100

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData(); // 1 2 3 4 5
        myList.showDataFromTail();

    }
}
