import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class isToeplitzMatrix {

	public static void main(String[] args) {
		// int[][] A = new int[3][4];
		// int rows = A.length;
		// int columns = A[0].length;
		// A[0][0] = 1;
		// A[0][1] = 2;
		// A[0][2] = 3;
		// A[0][3] = 4;
		// A[1][0] = 5;
		// A[1][1] = 1;
		// A[1][2] = 2;
		// A[1][3] = 3;
		// A[2][0] = 9;
		// A[2][1] = 5;
		// A[2][2] = 1;
		// A[2][3] = 2;

		int[][] A = new int[2][3];
		A[0][0] = 0;
		A[0][1] = 33;
		A[0][2] = 98;
		A[1][0] = 34;
		A[1][1] = 22;
		A[1][2] = 33;

		// System.out.println("Rows >>" + rows + " Columns>>" + columns);
		isToeplitzMatrix tm = new isToeplitzMatrix();
		System.out.println(tm.isToeplitzMatrix(A));
		System.out.println(Arrays.deepToString(tm.revertedMatrix(A)));

	}

	public boolean isToeplitzMatrix(int[][] matrix) {
		isToeplitzMatrix itm = new isToeplitzMatrix();
		boolean result = itm.validateMatrix(matrix);
		int[][] revertedMatrix = itm.revertedMatrix(matrix);
		if (result == true)
			result = itm.validateMatrix(revertedMatrix);
		return result;
	}

	public boolean validateMatrix(int[][] matrix) {

		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean result = false;
		for (int i = 0; i <= columns - 1; i++) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			int tempRows = rows - 1;
			for (int j = i; j >= 0 && tempRows >= 0; j--) {
				// System.out.print("" + tempRows + " " + j + " ");
				tempList.add(matrix[tempRows][j]);
				tempRows--;
			}
			result = new HashSet<Integer>(tempList).size() <= 1;
			// System.out.println();
			// System.out.println(" Row Result >>>" + result);
			if (result == false)
				break;
		}

		if (result == true) {
			for (int i = 0; i <= rows - 1; i++) {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				int tempColumns = columns - 1;
				for (int j = i; j >= 0 && tempColumns >= 0; j--) {
					// System.out.print("" + j + " " + tempColumns + " ");
					tempList.add(matrix[j][tempColumns]);
					tempColumns--;
				}
				result = new HashSet<Integer>(tempList).size() <= 1;
				// System.out.println();
				// System.out.println("Column Result >>>" + result);
			}
		}
		return result;
	}

	public int[][] revertedMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] revertedmatrix = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				revertedmatrix[j][i] = matrix[i][j];
			}
		}
		return revertedmatrix;
	}

}
