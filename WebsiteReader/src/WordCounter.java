
import java.util.ArrayList;
import java.util.List;


public class WordCounter {

	/**
	 * @param args
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
				write.set(list.get(i), "1");
			}
		}
		return write;
		
		

	}

}
