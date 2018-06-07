import java.util.*;

public class FindDisappearedNumbers {

	public static void main(String[] args) {
		// int A[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		int A[] = {1,1};
		FindDisappearedNumbers fdn = new FindDisappearedNumbers();
		System.out.println(fdn.findDisappearedNumbers(A));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		Integer[] numsInt = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		List<Integer> result = new ArrayList<Integer>();
		Set<Integer> numSet = new HashSet<Integer>();
		Collections.addAll(numSet, numsInt);
		if (numSet.size() > 0) {
			for (int i = 1; i <= nums.length; i++) {
				if (!numSet.contains(i))
					result.add(i);
			}
		}
		return result;

	}
}
