import java.util.ArrayList;
import java.util.List;

public class MaxSumSubArray {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(-500);
//		A.add(2);
//		A.add(0);
//		A.add(-1);
		MaxSumSubArray max = new MaxSumSubArray();
		System.out.println(max.maxSubArray(A));
	}

	public int maxSubArray(final List<Integer> A) {
		int maxSum = Integer.MIN_VALUE;
		for(int start_index=0;start_index<A.size();start_index++){
			int sum = 0;
			for(int subArray_size=1;subArray_size<=A.size();++subArray_size){
				if(start_index+subArray_size > A.size()) break;
				sum= sum + A.get(start_index+subArray_size-1);
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
    }
}
