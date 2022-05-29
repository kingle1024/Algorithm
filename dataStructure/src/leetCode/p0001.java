package leetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class p0001 {
	/*
	 * N개의 자연수가 있는 수열이 주어진다.
다음 두 가지 과정을 순서대로 한 것을 한 라운드라고 부른다.
모든 수열이 정렬되는 데까지는 몇 라운드가 필요한지 계산하라.
(아래 라운드 진행에 대한 설명에서는 N이 5 이상인 것을 가정하고 있으나 N이 더 작은 경우에도 동일한 방식으로 진행할 수 있음에 유의하라.

예를 들어 N=4인 경우, 아래 (2)번의 네 번째와 다섯 번째를 비교하는 것은 당연히 실행하지 않는다.)

(1)  첫 번째와 두 번째를 비교하여 첫 번째가 더 큰 경우 교환한다.
     세 번째와 네 번째를 비교하여 세 번째가 더 큰 경우 교환한다.
     즉, 홀수 번째 원소와 그 다음 원소(존재하는 경우)를 비교하고 교환하는 것을 모든 수열에 시행한다.

(2)  두 번째와 세 번째를 비교하여 두 번째가 더 큰 경우 교환한다.
     네 번째와 다섯 번째를 비교하여 네 번째가 더 큰 경우 교환한다.
     즉, 짝수 번째 원소와 그 다음 원소(존재하는 경우)를 비교하고 교환하는 것을 모든 수열에 시행한다.

처음에 주어진 수열이 아래와 같다고 하자.

수열 좌우의 대괄호와 값들 사이의 콤마는 설명에서 구분을 위한 것으로 입력으로는 주어지지 않는다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		ArrayList<ArrayList<Integer>> arrayTotal = new ArrayList();
		ArrayList<Integer> array;
		int[] arrSize = new int[T];
		int[] resultCnt = new int[T];
		for(int i=0; i<T; i++) {
			array = new ArrayList();
			arrSize[i] = sc.nextInt();
			for(int j=0; j < arrSize[i]; j++) {
				array.add(sc.nextInt());
			}
			arrayTotal.add(array);
		}

		int temp = 0;
		int cnt = 0;

		for(int i=0; i<arrayTotal.size(); i++) {
			cnt = 0;
			int arr[] = new int[arrayTotal.get(i).size()];
			for(int k = 0; k < arrayTotal.get(i).size(); k++){
				arr[k] = arrayTotal.get(i).get(k);
			}
			for(int z=0; z<arr.length-1; z+=2) {
				if(arr[z] > arr[z+1]) {
					temp = arr[z];
					arr[z] = arr[z+1];
					arr[z+1] = temp;
					cnt++;
//					System.out.println("test:"+Arrays.toString(arr));
				}
			}
			for(int g=1; g<arr.length-1; g+=2) {
				if(arr[g] > arr[g+1]) {
					temp = arr[g];
					arr[g] = arr[g+1];
					arr[g+1] = temp;
					cnt++;
//					System.out.println("test:"+Arrays.toString(arr));
				}
			}
			resultCnt[i] = cnt;
		}

		for(int i=0; i<resultCnt.length; i++) {
			System.out.println("#"+(i+1)+" "+resultCnt[i]);
		}

		sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
