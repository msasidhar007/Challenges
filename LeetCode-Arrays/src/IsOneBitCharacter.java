import java.util.*;

public class IsOneBitCharacter {

	public static void main(String[] args) {
		IsOneBitCharacter isOneBit = new IsOneBitCharacter();
		int A[] = { 1,0,0,0 };
		System.out.println(isOneBit.isOneBitCharacter(A));

	}

	public boolean isOneBitCharacter(int[] bits) {
		Integer[] numsInt = Arrays.stream(bits).boxed().toArray(Integer[]::new);
		List<Integer> bitsList = new ArrayList<Integer>();
		Collections.addAll(bitsList, numsInt);
		if (!bitsList.contains(1)) {
			return true;
		}
		int i = 0;
		boolean result = false;
		while (true) {
			if (i > bits.length - 1) {
				break;
			}
			if ((bits[i] == 1 && bits[i + 1] == 0) || (bits[i] == 1 && bits[i + 1] == 1)) {
				result = false;
				i = i + 2;
				System.out.println("i+2>>>" + i);
			} else {
				result = true;
				i = i + 1;
				System.out.println("i+1>>>" + i);
			}

		}
		return result;
	}
}
