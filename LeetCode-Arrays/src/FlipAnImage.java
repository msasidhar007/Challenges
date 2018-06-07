import java.util.Arrays;

public class FlipAnImage {

	public static void main(String[] args) {
		int[][] A = new int[3][3];

		A[0][0] = 1;
		A[0][1] = 1;
		A[0][2] = 0;
		A[1][0] = 1;
		A[1][1] = 0;
		A[1][2] = 1;
		A[2][0] = 0;
		A[2][1] = 0;
		A[2][2] = 0;
		FlipAnImage fp = new FlipAnImage();
		A = fp.flipAndInvertImage(A);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.print(A[i][j]);
			}
			System.out.println("\n");
		}
	}

	public int[][] flipAndInvertImage(int[][] A) {
		int[][] B = new int[3][3];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				B[i][j] = A[i][j];
			}
		}

		for (int i = 0; i < A.length; i++) {
			int counter = A.length - 1;

			for (int j = 0; j < A.length; j++) {
				if (B[i][counter] == 1) {
					A[i][j] = 0;
				} else
					A[i][j] = 1;
				counter--;
			}
		}
		return A;
	}

}
