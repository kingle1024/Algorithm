package ZeroBase.Class;

// 입출력 예시)
// 입력 연결 리스트 : 1, 3, 3, 1, 4, 2, 4, 2
// 결과 연결 리스트 : 1, 3, 4, 2
public class Part2_Chapter02_Class04_Practice01 {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(new Node(1, null));
//        myList.addData(5);
        myList.addData(3);
        myList.addData(3);
        myList.addData(1);
        myList.addData(4);
        myList.addData(2);
        myList.addData(4);
        myList.addData(2);
        myList.addData(5);
//        myList.showData();
        myList.showDataRemoveDuplicate();

    }
}
