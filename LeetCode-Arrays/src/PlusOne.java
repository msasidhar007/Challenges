import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class PlusOne {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(6);
		A.add(0);
		A.add(6);
		A.add(4);
		A.add(8);

		PlusOne po = new PlusOne();
		System.out.println(po.plusOneOptimal(A));

	}

	public ArrayList<Integer> plusOneOptimal(ArrayList<Integer> A) {
		ArrayList<Integer> targetList = new ArrayList<Integer>();
		while(A.size()!=1){
			if(A.get(0)==0) A.remove(0);
			else
				break;
		}
		
		System.out.println(A);
		boolean flag = false;
		for (int i = A.size() - 1; i >= 0; i--) {
			if (A.get(i) + 1 == 10 && A.size() - 1 == i) {
				targetList.add(0);
				flag = true;

			} else if (A.size() - 1 == i) {
				targetList.add(A.get(i) + 1);
			} else {
				if (flag == true) {
					if (A.get(i) + 1 == 10) {
						targetList.add(0);
						flag = true;
					} else {
						targetList.add(A.get(i) + 1);
						flag = false;
					}
				} else {
					targetList.add(A.get(i));
				}
			}
		}
		if (flag == true)
			targetList.add(1);

		Collections.reverse(targetList);
		return targetList;
	}
}
