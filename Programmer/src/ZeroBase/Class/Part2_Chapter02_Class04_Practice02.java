package ZeroBase.Class;

// Panlindrome 연결 리스트
// 추가 자료구조 없이 연결 리스트만으로 풀어보기
// Palindrome : 앞으로 읽어도 뒤로 읽어도 같은 문자열
// 입력 예시)
// 입력 연결 리스트 :1, 3, 5, 3, 1
// 결과 : true

// 입력 연결 리스트 :3, 5, 5, 3
// 결과 : true

// 입력 연결 리스트 :1, 3, 5, 1
// 결과 : true
public class Part2_Chapter02_Class04_Practice02 {
    public static boolean checkPalindrome(LinkedList list){
        if(list.isEmpty()){
            return false;
        }
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while(cur != null){
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        for (int i = 0; i < cnt/2; i++) {
            if(left.data != right.data){
                return false;
            }

            left = left.next;
            right = left;
            while(right.next != prevRight){
                right = right.next;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        // Test code
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(7);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList));

    }




}
