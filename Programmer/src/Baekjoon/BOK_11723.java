package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOK_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());

        HashSet<String> hashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String num = null;
            if(st.hasMoreTokens()) num = st.nextToken();

            switch (s){
                case "add":{
                    hashSet.add(num);
                    break;
                }
                case "remove":{
                    if(hashSet.contains(num)){
                        hashSet.remove(num);
                    }
                    break;
                }
                case "check":{
                    if(hashSet.contains(num)){
                        sb.append("1\n");
                    }else {
                        sb.append("0\n");
                    }
                    break;
                }
                case "toggle":{
                    if(hashSet.contains(num)){
                        hashSet.remove(num);
                    }else{
                        hashSet.add(num);
                    }
                    break;
                }
                case "all":{
                    hashSet.clear();
                    for (int j = 1; j <= 20; j++) {
                        hashSet.add(String.valueOf(j));
                    }
                    break;
                }
                case "empty":{
                    hashSet.clear();
                }
            }
        }
        System.out.println(sb);
    }

}
