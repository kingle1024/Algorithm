import java.util.ArrayList;

class MySet{
    // ArrayList
    ArrayList<Integer> list;

    // 생성자1
    MySet(){
        this.list = new ArrayList<Integer>();
    }
    // 생성자2
    MySet(int arr[]){
        this.list = new ArrayList<Integer>();
        for(int item: arr){
            this.list.add(item);
        }
    }
    // 원소 추가 (중복 X)
    public void add(int x){
        for(int item : this.list){
            if(item == x){
                return;
            }
        }
        this.list.add(x);
    }
    // 교집합
    public MySet retainAll(MySet mySet)  {
        MySet result = new MySet();
        for(int i=0; i<this.list.size(); i++){
            for(int j=0; j<mySet.list.size(); j++){
                if(this.list.get(i) == mySet.list.get(j)){
                    result.add(mySet.list.get(j));
                }
            }
        }
        return result;
    }
    // 합집합
    public MySet addAll(MySet mySet){
        MySet result = new MySet();
        result.list = this.list;
        for(int item: mySet.list){
            result.add(item);
        }
//        for(int i=0; i<this.list.size(); i++){
//            for(int j=0; j<mySet.list.size(); j++){
//                if(this.list.get(i) != mySet.list.get(j)){
//                    result.add(mySet.list.get(j));
//                }
//            }
//        }
        return result;
    }

    // 차집합
    public MySet removeAll(MySet mySet){
        MySet result = new MySet();
        boolean check = false;
//        for(int i=0; i<this.list.size(); i++){
//            check = false;
//            for(int j=0; j<mySet.list.size(); j++){
//                if(this.list.get(i) == mySet.list.get(j)){
//                    check = true;
//                }
//            }
//            if(!check){
//                result.add(this.list.get(i));
//            }
//        }
        for(int a : this.list){
            check = false;
            for(int b :mySet.list){
                if(a == b){
                    check = true;
                    break;
                }
            }
            if(!check) result.add(a);
        }

        return result;
    }
}
public class Part2_Chapter1_Class02 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Test code
        MySet a = new MySet();
        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list); // [2, 4]

        result = a.addAll(b);
        System.out.println("합집합: " + result.list); // [1, 2, 3, 4, 5, 6, 8, 10]

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list); // [1, 3, 5]
    }
}
