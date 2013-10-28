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
		List<String> sorted = new ArrayList<String>();
		for (int i = 0; i < x.length(); i++){
			if (x.charAt(i) == '<'){
				String y = x.substring(i, x.indexOf('>',i) +1);
				x = x.replace(y, "");
				i=-1;
			}
			else if (x.charAt(i) == ':'){
				String y = x.substring(i-1, x.indexOf(',',i) +1);
				x = x.replace(y, "");
				i=-1;
			}
		}
		String[] pre = x.split(" ");
		for (int i = 0; i < pre.length; i++){
			sorted.add(pre[i]);
		}
		return sorted;
	}
	

}
