package leetCode;

public class p48 {
	public static void main(String[] args) {
		int arr[][] = {
		               {1,2,3},
		               {4,5,6},
		               {7,8,9}
		};
		rotate(arr);
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
//		System.out.println(arr);
	}
    public static void rotate(int[][] matrix) {
    	if(matrix.length != matrix[0].length) return;
    	int[][] copy = new int[matrix.length][matrix[0].length];
    	for(int i=0; i<matrix.length; i++){
    		copy[i] = matrix[i].clone(); // 이 문제의 핵심
    	}
    	int index = matrix.length-1;
    	for(int i=0; i<matrix.length; i++){
    		for(int j=0; j<matrix[i].length; j++){
    			matrix[j][index] = copy[i][j];
    		}
    		index--;
    	}
    }
}
