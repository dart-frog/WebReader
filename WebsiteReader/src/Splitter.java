import java.util.ArrayList;
import java.util.List;


public class Splitter {
	
	public static List<String> split (String x){
	String[] xs = x.split("<");
	ArrayList<String> sorted = new ArrayList();	
	for (int i = 0; i < xs.length; i++){
			if (!xs[i].isEmpty() && xs[i].charAt(xs[i].length() -1) != '>' ){
				sorted.add(xs[i]);
			}
			
		}
	return sorted;
	}

}
