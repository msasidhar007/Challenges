import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		int A[] = { 0, 1, 0, 3, 12 };
		MoveZeros mz = new MoveZeros();
		mz.moveZeroes(A);
	}

	public void moveZeroes(int[] nums) {
		int count = countZeros(nums);
		System.out.println("Count >>"+count);
		nums = rearrangeZeros(nums, count);
		System.out.println(Arrays.toString(nums));
    }
	
	
	public static int countZeros(int[] nums){
		int count = 0;
		for(int i : nums){
			if(i==0) count++;
		}
		return count;
	}
	
	public static int[] rearrangeZeros(int[] nums,int count){
		ArrayList<Integer> numsList = new ArrayList<Integer>();
		for(int i:nums){
			if(i != 0){
				numsList.add(i);
			}
		}
		for(int j=0;j<count;j++) numsList.add(0);
		return numsList.stream().mapToInt(i->i).toArray();
	}

}
