package leetCode;

public class p867 {
	public static void main(String[] args) {
		int A[][] = {
				{1,2,3},{4,5,6}
		};
		int B[][] = transpose(A);
		for(int i=0; i<B.length; i++){
			for(int j=0; j<B[0].length; j++){
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		
	}
    public static int[][] transpose(int[][] A) {
        int result[][] = new int[A[0].length][A.length]; // 3, 2
        for(int i=0; i<A[0].length; i++){
            for(int j=0; j<A.length; j++){
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
