package dataStructure;

public class binarySearch {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		System.out.println(binarySearch(arr));	
	}
	public static int binarySearch(int arr[]) {
		int index = arr.length/2; // 중간 위치부터 시작하도록 디폴트 값은 arr.length/2
		int preIndex= arr.length; // 이전 값을 저장한다. 처음부터 searchNum이 클 수가 있으니 디폴트 값은 arr.length
		int searchNum = 3;
		
		while(true) {
			if(arr[index] == searchNum) {
				return index;
			}else if(arr[index] > searchNum) {
				preIndex = index;
				index = index/2;
			}else if(arr[index] < searchNum) {
				index = (preIndex - index)/2;
			}
		}
	}
}
