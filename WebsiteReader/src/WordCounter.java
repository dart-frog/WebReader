
import java.util.ArrayList;
import java.util.List;


public class WordCounter {

	/**
	 * @param args
	 */
	public static MyHashMap reader(ArrayList<String> list) {
		MyHashMap write = new MyHashMap(10);
		for (int i = 0; i < list.size(); i++){
			if(write.exists(list.get(i))){
				String old = write.get(list.get(i));
				int noon = Integer.parseInt(old);
				noon++;
				write.change(list.get(i), Integer.toString(noon));
			}
			else{
				write.set(list.get(i), "1");
			}
		}
		return write;
		
		

	}

}
