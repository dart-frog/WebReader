import java.util.ArrayList;
import java.util.List;

/**
 * Uses the bubble sort method to rearrange a list of key value pairs from lowest to highest
 * @author Nate
 *
 */
public class BubbleSort {
	/**
	 * sorts the list using the bubble sort method
	 * @param xlist the unsorted list
	 * @return the sorted list
	 */
	public static List<KeyValuePairs> sort(ArrayList<KeyValuePairs> xlist){
		for (int j = 0; j < (xlist.size()-1); j++){
			for (int i = 0; i < (xlist.size() -1); i++){
				if (translate(xlist.get(i)) > translate(xlist.get(i+1))){
					KeyValuePairs x = xlist.get(i);
					 xlist.set(i, xlist.get(i+1));
					 xlist.set(i+ 1, x);
				}
			}
		}
		
		
		return xlist;
		
	}
	/**
	 * Takes a key value pair and spits out the value as an interger 
	 * @param x the key value pair
	 * @return the value as an interger 
	 */
	public static int translate(KeyValuePairs x){
		String p = x.getValue();
		int q = Integer.parseInt(p);
		return q;
	}
}
