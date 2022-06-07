package ZeroBase.Class;

class Node2{
    int data;
    Node2 next;

    Node2(int data, Node2 next){
        this.data = data;
        this.next = next;
    }
}
class LinkedList2{
    Node2 head;
    LinkedList2(Node2 node2){
        this.head = node2;
    }

    void addData(int data){
        if(this.head == null){
            this.head = new Node2(data, null);
            return;
        }else {
            Node2 cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node2(data, null);
        }
    }
    // before data가 null인 경우 가장 뒤에 추가
    void addData(int data, int idx){
        Node2 cur = this.head;
        if(this.head == null){
            cur = new Node2(data, null);
            return;
        }
        Node2 next;

        for(int i=0; i<idx-1; i++){
            cur = cur.next;
        }
        next = cur.next;
        Node2 n = new Node2(data, next);
        cur.next = n;
    }
    void removeData(){
        if(this.head == null){
            System.out.println("List is empty");
            return;
        }
        Node2 cur = this.head;
        Node2 Prev = cur;
        while(cur.next != null){
            Prev = cur;
            cur = cur.next;
        }

        Prev.next = null;
    }
    void removeData(int data){
        Node2 cur = this.head;
        Node2 next = null;
        Node2 prev = null;
        if(cur.next == null){
            this.head = null;
            return;
        }

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
            if (prev.data == data) {
                this.head = cur;
                break;
            } else if (cur.data == data) {
                next = cur.next;
                cur.next = null;
                prev.next = next;
                break;
            }
        }
    }
    void showData(){
        if(this.head == null){
            System.out.println("List is Empty!");
            return;
        }
        Node2 cur = this.head;
        while(cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

}

public class Part2_Chapter02_Class04_Practice {
    public static void main(String[] args) {
        // Test code
        LinkedList2 myList = new LinkedList2(new Node2(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.removeData();
        myList.showData();

        System.out.println("=====");
        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();

        System.out.println("=====");
        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();

        System.out.println("=====");
        myList.removeData(1);
        myList.removeData(2);
        myList.removeData(3);
        myList.removeData(4);
        myList.showData();
    }
}

/*
The profile appears to be in use by another Google Chrome process (78525) on another computer (kingle-ThinkPad-Edge-E320).  Chrome has locked the profile so that it doesn't get corrupted.  If you are sure no other processes are using this profile, you can unlock the profile and relaunch Chrome.
 */