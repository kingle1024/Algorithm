package dataStructure;

public class binarySearchRecursive {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(bsr(arr, 0, arr.length, 9));	
	}
	public static int bsr(int arr[], int first, int last, int target){
		int mid = (first+last)/2;
		if(arr[mid] == target){
			return mid;
		}else if(arr[mid] < target){
			first = mid;
			return bsr(arr, first, last, target);
		}else if(arr[mid] > target){
			last = mid;
			return bsr(arr, first, last, target);
		}
		return -1;
	}
}
