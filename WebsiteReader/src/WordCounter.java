
import java.util.ArrayList;
import java.util.List;


public class WordCounter {

	/**
	 * counts the number of words in a hashmap
	 * @param list words that you would like to count
	 * @param write a hashmap to store counts
	 * @return a counted hashmap
	 */
	public static MyHashMap reader(ArrayList<String> list, MyHashMap write) {
		String old = "";
		int noon = 0;
		for (int i = 0; i < list.size(); i++){
			if(write.exists(list.get(i))){
				try {
					old = write.get(list.get(i));
					noon = Integer.parseInt(old);
				} catch(NumberFormatException e) {
					System.out.println("\"" + list.get(i) + "\"");
					throw e;
				}
				noon++;
				write.change(list.get(i), Integer.toString(noon));
			}
			else{
				if(isLegit(list.get(i))){ 
				//String low = list.get(i).toLowerCase();
				String low = list.get(i);
				write.set(low, "1");
				}
			}
		}
		return write;
		
		

	}
	private static boolean isLegit(String input){
		char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
		for	(int j = 0; j< input.length(); j++){
			for (int i = 0; i< nums.length; i++){
				if (input.charAt(j) == nums[i]){
					return false;
				}
				
			}
		}
		if (input.equals("-")){
			return false;
		}
		if (input.equals("")){
			return false;
		}
		
		return true;
		
	}

}
