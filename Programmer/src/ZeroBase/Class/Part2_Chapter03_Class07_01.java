package ZeroBase.Class;

import java.util.ArrayList;

class MaxHeap{
    ArrayList<Integer> heap;
    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미 데이터
    }
    public void insert(int data){
        heap.add(data);
        int cur = heap.size() - 1;
        while(cur > 1 && heap.get(cur / 2) < heap.get(cur)){ // 부모쪽 인덱스보다 크면
            int parentVal = heap.get(cur/2);
            heap.set(cur/2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }
    public Integer delete(){
        if(heap.size() == 1){
            System.out.println("Heap is empty!");
            return null;
        }
        int target = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int cur = 1;
        while(true){
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()){ // 오른쪽 노드가 있는지 확인
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            }else if(leftIdx < heap.size()){
                targetIdx = cur * 2;
            }else{ // 부모 노드가 없거나 더이상 비교가 불가한 경우
                break;
            }

            if(heap.get(cur) > heap.get(targetIdx)){
                break;
            }else{ // 서로 변경해줌.
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }
    public void printTree(){
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) +" ");
        }
        System.out.println();
    }
}

public class Part2_Chapter03_Class07_01 {
    public static void main(String[] args) {
// Test Code
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        maxHeap.insert(20);
        maxHeap.printTree();
        maxHeap.insert(30);
        maxHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제 : " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제 : " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제 : " + maxHeap.delete());
        maxHeap.printTree();
    }
}
