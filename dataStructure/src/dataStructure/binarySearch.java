package dataStructure;

public class binarySearch {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		System.out.println(binarySearch(arr));	
	}
	public static int binarySearch(int arr[]) {
		int index = arr.length/2; // �߰� ��ġ���� �����ϵ��� ����Ʈ ���� arr.length/2
		int preIndex= arr.length; // ���� ���� �����Ѵ�. ó������ searchNum�� Ŭ ���� ������ ����Ʈ ���� arr.length
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
