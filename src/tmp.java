import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;
// retourne les char associé à leur nombre d'occurence
public HashMap<Character, Integer> getSize(char[][] cells) {
	HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
	for (int i = 0; i < cells.length; i += 1) {
		for (int j = 0; j < cells.length; j += 1) {
			if (hashmap.get(cells[i][j]) != null)
				hashmap.put(cells[i][j], hashmap.get(cells[i][j]) + 1);
			else 
				hashmap.put(cells[i][j], 1);
		}
	}
	return hashmap;
}

public TreeMap<Character, Integer> sortMap(HashMap<Character, Integer> hashmap) {
	
	return hashmap;
}


// Comparator<Case> myInterface = new Comparator<Case>() {
		// 	public int compare(Case c1, Case c2) {
		// 		if (c1.estimation < c2.estimation)
		// 			return -1;
		// 		else if (c1.estimation > c2.estimation)
		// 			return 1;
		// 		else 
		// 			return 0;
		// 	}
		// };
		// PriorityQueue<Case> openList = new PriorityQueue<Case>(myInterface);