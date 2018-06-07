import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] nums = {2,2,1,1,1,2,2};
		me.majorityElement(nums);
	}

	public int majorityElement(int[] nums) {
		Map<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
		for(int n : nums){
			if(freqMap.containsKey(n)){
				int count = freqMap.get(n);
				freqMap.put(n, count+1);
			}
			else{
				freqMap.put(n, 1);
			}
		}
		int maxCount = Collections.max(freqMap.values());
		int result = freqMap.entrySet().stream().filter(f -> f.getValue() == maxCount).collect(Collectors.toList()).get(0).getKey();
//		System.out.println(result);
		return result;
	}
}
