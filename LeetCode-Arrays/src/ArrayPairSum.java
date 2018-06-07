import java.util.Arrays;

public class ArrayPairSum {

	public static void main(String[] args) {
		int[] A = {1,4,3,2};
		ArrayPairSum aps = new ArrayPairSum();
		System.out.println(aps.arrayPairSum(A));
		
	}

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int pairSum = 0;
		for(int i=0;i<nums.length;i=i+2){
//			System.out.println("Number at i>>>>" + nums[i] + " i+1>>>>"+nums[i+1]);
			pairSum = pairSum + Math.min(nums[i], nums[i+1]);
		}
		return pairSum;
	}

}
