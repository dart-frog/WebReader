
import java.util.ArrayList;
import java.util.List;


public class WordCounter {

	/**
	 * @param args
	 */
	public static List<KeyValuePairs> reader(ArrayList<String> list) {
		MyHashMap write = new MyHashMap(10);
		for (int i = 0; i < list.size(); i++){
			if(write.exists(list.get(i))){
				
			}
			else{
				write.set(list.get(i), "1");
			}
		}

	}

}
