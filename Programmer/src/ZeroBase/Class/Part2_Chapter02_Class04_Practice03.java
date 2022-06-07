package ZeroBase.Class;

// 입력 예시)
// 입력 연결 리스트 :1, 2, 3, 4, 5
// 시작 위치 : 2
// 끝 위치 : 4
// (처음 위치는 1부터라고 가정)
// 결과 연결 리스트 1, 4, 3, 2, 5

public class Part2_Chapter02_Class04_Practice03 {
    public static LinkedList reverseList(LinkedList list, int left, int right){
        if(list.isEmpty()){
            System.out.println("List is Empty!");
            return null;
        }

        while(true){
            Node cur = list.head;
            Node l = list.head;
            Node r = null;
            int leftCnt = 0;
            while (leftCnt != left - 1) {
                cur = cur.next;
                leftCnt++;
            }
            l = cur;
            r = cur;
            int rightCnt = 0;
            while (rightCnt != (right - left)) {
                cur = cur.next;
                rightCnt++;
            }
            r = cur;

            int temp = -1;

            // swap 부분
            temp = l.data;
            l.data = r.data;
            r.data = temp;
            left +=1;
            right -=1;

            if(left == right || l.next == r) break;
        }

        return list;
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.showData();
        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showData();
        System.out.println("========");

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(1);
        linkedList2.addData(2);
        linkedList2.addData(3);
        linkedList2.addData(4);
        linkedList2.addData(5);
        linkedList2.addData(6);
        linkedList2.addData(7);
        linkedList2.showData();

        linkedList2 = reverseList(linkedList2, 3, 5);
        linkedList2.showData();



    }
}
