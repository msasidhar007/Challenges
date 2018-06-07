
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		MaxConsecutiveOnes maxC = new MaxConsecutiveOnes();
//		int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
		int[] A = {1};
		System.out.println(maxC.maxOnes(A));
	}

	public int maxOnes(int[] A) {
		int onesCount = 0;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if(i==0 && A[i]==1){
				count = 1;
				onesCount = Math.max(onesCount, count);
			}
			
			if(i > 0 && A[i]==1 && A[i] == A[i-1]){
				count  = count+1;
				onesCount = Math.max(onesCount, count);
			}
			else if(A[i]==1){
				count = 1;
				onesCount = Math.max(onesCount, count);
			}
			else
				count = 0;
			
		}
		return onesCount;
	}
}
