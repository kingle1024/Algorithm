package leetCode;


public class p832 {
	public static void main(String[] args) {
		int [][]A = {{1,1,0},{1,0,1}, {0,0,0}};
		flipAndInvertImage(A);
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[i].length; j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] flipAndInvertImage(int[][] A){
        int temp;
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[i].length/2; j++){
				if(A[i][j] != A[i][A[i].length-j-1]){ // 다르면 실행
					temp = A[i][j];
					A[i][j] = A[i][A[i].length-j-1];
					A[i][A[i].length-j-1] = temp;
				}
			}
			for(int z=0; z<A[i].length; z++){
				if(A[i][z] == 0)
					A[i][z] = 1;
				else
					A[i][z] = 0;
			}
		}
		return A;
	}
}
