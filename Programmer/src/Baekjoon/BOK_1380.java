package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> result = new HashMap<>();
        int senarioSeq = 1;
        while(true){
            int loop = Integer.parseInt(br.readLine());
            if(loop == 0) break;

            Map<Integer, String> studentNames = new HashMap<>();
            Map<String, String> studentGet = new HashMap<>();
            for (int i = 1; i <= loop; i++) {
                String s = br.readLine();
                studentNames.put(i, s);
                studentGet.put(s, "0");
            }

            for (int i = 1; i <= (2*loop) -1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int seq = Integer.parseInt(st.nextToken());
                String jewelry = st.nextToken();
                String stName = studentNames.get(seq);
                if(studentGet.get(stName).equals("A") && jewelry.equals("B")) {
                    studentNames.remove(seq);
                    studentGet.remove(stName);
                }else if(studentGet.get(stName).equals("B") && jewelry.equals("A")){
                    studentNames.remove(seq);
                    studentGet.remove(stName);
                }else{
                    studentGet.put(stName, jewelry);
                }
            }

            Iterator<Integer> keys = studentNames.keySet().iterator();
            while(keys.hasNext()){
                int key = keys.next();
                result.put(senarioSeq, studentNames.get(key));
            }
            senarioSeq++;
        }

        Iterator<Integer> resultKeys = result.keySet().iterator();
        while(resultKeys.hasNext()){
            int key = resultKeys.next();
            System.out.printf("%d %s\n", key, result.get(key));
        }
    }
}
