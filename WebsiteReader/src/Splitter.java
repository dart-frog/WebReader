import java.util.ArrayList;
import java.util.List;


public class Splitter {
	
/*	public static List<String> split (String x){
		String[] xs = x.split("<");
		ArrayList<String> sorted = new ArrayList();	
		for (int i = 0; i < xs.length; i++){
			if(!xs[i].isEmpty()){
				boolean isTrash = false;
				for (int j = 0; j < xs[i].length(); j++){
					if (xs[i].charAt(j) == '>'){
						xs[i]
						
					}
				}
			}
		}
		return sorted;
	}*/
	public static List<String> split (String x){
		String sorted;
		for (int i = 0; i < x.length(); i++){
			if (x.charAt(i) == '<'){
				String y = x.substring(x.charAt(i), x.indexOf('>'));
				sorted.x.replace(y, "");
			}
		}
	}
	

}
