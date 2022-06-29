package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOK_13305 {
    public static void main(String[] args) throws Exception{
        solution();
    }
    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] length = new long[N-1];
        long[] prices = new long[N];
        int min = 0;
        long totalLength = 0;
        String[] arrTmp = br.readLine().split(" ");
        for(int j=0; j<arrTmp.length; j++){
            length[j] = Integer.parseInt(arrTmp[j]);
            totalLength += length[j];
        }

        arrTmp = br.readLine().split(" ");
        for(int j=0; j<arrTmp.length; j++){
            prices[j] = Integer.parseInt(arrTmp[j]);
            if(j != arrTmp.length-1){
                if(prices[min] > prices[j]){
                    min = j;
                }
            }
        }
        long result = 0;
        long goLength = 0;
        int idx = 0;
        while(true){
            if(idx == prices.length) break;
            if(prices[idx] == prices[min]){ // change
                result = result + (prices[idx] * (totalLength-goLength));
//                System.out.println("[1] "+result);
                break;
            }else if(prices[idx] > prices[min]){
                int nextIdx = idx+1;
                long nLength = length[idx];
//                System.out.println(idx + " " + nLength);
                while(true){
                    if(prices[nextIdx] < prices[idx]){
                        result += (prices[idx] * nLength);
                        idx = nextIdx;
                        break;
                    }
                    nLength += length[nextIdx];
                    nextIdx++;
                }
                goLength += nLength;
//                System.out.println(""+idx+" " + nextIdx+" "+ result+" " + nLength + " " +goLength);
            }else{
                result = result + (prices[idx] * length[idx]);
                goLength += length[idx];
//                System.out.println("[2] "+result);
                idx++;
            }

        }

        System.out.println(result);
    }
}
