package ZeroBase.Class;
class Node{
    int data;
    Node next;

    Node(){}
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
class LinkedList{
    Node head;
    LinkedList() {}
    LinkedList(Node node){
        this.head = node;
    }

    // 연결 리스트 비어있는지 확인
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    // 연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data){
        if(this.head == null){
            this.head = new Node(data, null);
        }else{
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    // 연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData(){
        if(this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }else{
            Node cur = this.head;
            Node prev = cur;

            while(cur.next != null){
                prev = cur;
                cur = cur.next;
            }

            if(prev.next == null){
                this.head = null;
            }else {
                prev.next = null;
            }

        }
    }
    // 연결 리스트에서 데이터 찾기
    public void findData(int data){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.data == data) {
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not Found");
    }

    // 연결 리스트의 모든 데이터 출력
    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    public void showDataRemoveDuplicate(){
        Node cur = this.head;
        LinkedList myList = null;

        Node initCur = null;
        Node myListCur = null;
        Node itrCur = null;
        while(cur != null){
            int d = cur.data;
            if(myList == null){
                myList = new LinkedList(new Node(d, null));
                cur = cur.next;
                initCur = myList.head;
                System.out.println("add : "+d);
                continue;
            }
            boolean check = false;
            myListCur = initCur;
            while(myListCur.next != null){
                System.out.println("순환 ~ "+d+" "+myListCur.data);
                if(d == myListCur.data){
                    System.out.println("join");
                    check = true;
                    break;
                }
                myListCur = myListCur.next;
            }
            if(!check & d != myListCur.data){
                myListCur.next = new Node(d, null);
                System.out.println("add : "+d);
            }
            cur = cur.next;
        }
        System.out.println("=========");
        while(initCur != null){
            System.out.print(initCur.data +" ");
            initCur = initCur.next;
        }
    }
}
public class Part2_Chapter02_Class04 {
    public static void main(String[]args){
        // Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();

        for (int i = 0; i < 4; i++) {
            myList.addData(i+2);
        }
        myList.showData();

        myList.findData(3);
        myList.findData(100);

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();

        myList.removeData();
        myList.removeData();
        myList.removeData();

//        myList.showData();
    }
}
