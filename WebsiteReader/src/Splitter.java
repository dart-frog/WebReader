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
		boolean inBody = false;
		int d = 0;
		while ( !(x.charAt(d) == '<' &&  x.charAt(d +1) == 'b' && x.charAt(d+2) == 'o' && x.charAt(d+3) == 'd' && x.charAt(d+4) == 'y' && x.charAt(d+5) == '>')){
			d++;
		}
		x = x.substring(d , x.length()-1);
		for (int i = 0; i < x.length(); i++){
			
			if (x.charAt(i) == '<'){
				String y = x.substring(i, x.indexOf('>',i) +1);
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
