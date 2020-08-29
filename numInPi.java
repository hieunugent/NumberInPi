import java.util.*;

class Program {
  public static int numbersInPi(String pi, String[] numbers) {
    // Write your code here.
		Set<String> numbersTable = new HashSet<String>();
		for (String number : numbers){
			numbersTable.add(number);
		}
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		int minSpace = getMinSpaces(pi, numbersTable, cache, 0);
    return minSpace == Integer.MAX_VALUE ? -1: minSpace;
  }
	public static int getMinSpaces(
	String pi, Set<String> numbersTable, Map<Integer, Integer> cache, int idx){
		if (idx == pi.length()) return -1;
		if(cache.containsKey(idx)) return cache.get(idx);
		int minSpaces = Integer.MAX_VALUE;
		for(int i = idx; i < pi.length(); i++){
			String prefix = pi.substring(idx, i+1);
			if(numbersTable.contains(prefix)){
				int minSpaceInSuffix = getMinSpaces(pi, numbersTable, cache, i+1);
				if(minSpaceInSuffix == Integer.MAX_VALUE){
					minSpaces = Math.min(minSpaces,minSpaceInSuffix );
				}else{
					minSpaces = Math.min(minSpaces, minSpaceInSuffix +1);
				}
			}
		}
		cache.put(idx, minSpaces);
		return cache.get(idx);
	}
}
