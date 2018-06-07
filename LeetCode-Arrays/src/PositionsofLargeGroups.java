
import java.util.*;

public class PositionsofLargeGroups {

	public static void main(String[] args) {
		String input = "abbxxxxzyy";
		PositionsofLargeGroups polg = new PositionsofLargeGroups();
		System.out.println(polg.largeGroupPositions(input));
	}

	public List<List<Integer>> largeGroupPositions(String S) {
		Map<String, Integer> freqMap = new HashMap<String, Integer>();
		List<List<Integer>> largeGroupList = new ArrayList<List<Integer>>();
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();

		List<Integer> indexList = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (true) {
			if(i+1 >= S.length()){
				indexList.add(j);
				indexList.add(i);
				largeGroupList.add(indexList);
				break;
			}
			
			if(S.charAt(i) == S.charAt(i+1)){
				i=i+1;
			}else{
				indexList.add(j);
				indexList.add(i);
				largeGroupList.add(indexList);
				indexList = new ArrayList<Integer>();
				j = i+1;
				i = i+1;
			}
		}
		System.out.println("largeGroupList"+largeGroupList);
		for(List indexes : largeGroupList){
			int finalIndex = (int) indexes.get(1);
			int initIndex = (int) indexes.get(0);
			if(finalIndex-initIndex+1>=3){
				finalList.add(indexes);
			}
		}
		return finalList;
	}
}
