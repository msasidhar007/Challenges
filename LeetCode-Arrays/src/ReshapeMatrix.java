import java.util.Arrays;

public class ReshapeMatrix {

	public static void main(String[] args) {
		int[][] A = new int[2][2];
		A[0][0] = 1;
		A[0][1] = 2;
		A[1][0] = 3;
		A[1][1] = 4;
		ReshapeMatrix rm = new ReshapeMatrix();
		System.out.println(Arrays.deepToString(rm.matrixReshape(A, 4, 1)));

	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		int rows = nums.length;
		int columns = nums[0].length;
		int[][] reshapedMatrix = new int[r][c];
 		if ((rows * columns) != (r * c))
			return nums;
		else {
			int tempRows = 0; int tempColumns = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
				reshapedMatrix[i][j] = nums[tempRows][tempColumns];	
				if(tempColumns == columns-1) {
					tempRows++;
					tempColumns = 0;
				}
				else{
					tempColumns++;
				}
				}
			}
		}
		return reshapedMatrix;
	}
}
