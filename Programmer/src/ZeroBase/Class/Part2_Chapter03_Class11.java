package ZeroBase.Class;

import java.util.HashMap;

class Node_11{
    HashMap<Character, Node_11> child;
    boolean isTerminal;
    public Node_11(){
        this.child = new HashMap<Character, Node_11>();
        this.isTerminal = false;
    }
}
class Trie{
    Node_11 root;
    public Trie(){
        this.root = new Node_11();
    }
    public void insert(String str){
        Node_11 cur = this.root;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            // 현재 해당하는 문자가 cur 기준으로 없으면 넣어주고 있으면 넘어감
            cur.child.putIfAbsent(c, new Node_11());
            cur = cur.child.get(c); // 해당 위치로 이동함

            if(i == str.length() - 1){
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str){
        Node_11 cur = this.root;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(cur.child.containsKey(c)){
                cur = cur.child.get(c); // 해당 노드로 이동
            }else{
                return false;
            }

            if(i == str.length() - 1){
                if(!cur.isTerminal){
                    return false; // 유의해야 하는 부분 app을 넣어주지 않았다면 에러가 나야함
                }
            }
        }
        return true;
    }

    public void delete(String str){
        boolean ret = this.delete(this.root, str, 0);
        if(ret){
            System.out.println(str + " 삭제 완료");
        }else{
            System.out.println(str + " 단어가 없습니다.");
        }
        // true 값을 찾는다
        // true부터 쭉 지워준다.
        Node_11 cur = this.root;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(cur.child.containsKey(c)){
                cur = cur.child.get(c);
            }else{
                break;
            }

            if(i == str.length()-1){
                if(!cur.isTerminal){
                    break;
                }else{
                    // 삭제하는 로직을 진행
                    // 노드를 끊어준다.

                }
            }
        }

    }
    public boolean delete(Node_11 node, String str, int idx){
        char c = str.charAt(idx);
        if(!node.child.containsKey(c)){
            return false;
        }
        Node_11 cur = node.child.get(c);
        idx++;

        if(idx == str.length()){
            if(!cur.isTerminal){
                return false;
            }else{
                cur.isTerminal = false;
                if(cur.child.isEmpty()){ // 해당 단어로 시작하는 덕인 문자열이 없으면 하나씩 지워나감
                    node.child.remove(c);
                }
            }
        }else{ // 지워야 하는 단어를 찾기 전
            if(!this.delete(cur, str, idx)){ // 끝에 도달할 때까지 계속 재귀로 진행. false를 가져오면 false 떨어뜨려줌
                return false;
            }
            if(!cur.isTerminal && cur.child.isEmpty()){ // 끝 문자를 삭제한 다음에 앞에 문자들에서 파생되는 단어들이 없으면 함께 삭제하는 부분
                node.child.remove(c);
            }
        }

        return true;
    }
}
public class Part2_Chapter03_Class11 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("april"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ace"));
        System.out.println(trie.search("bear"));
        System.out.println(trie.search("best"));
        System.out.println(trie.search("abc"));

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("april"));
        System.out.println(trie.search("appl"));
        trie.delete("apple");
    }
}
