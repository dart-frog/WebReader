import java.util.ArrayList;
import java.util.List;


public class Splitter {
	
	/**
	 * Splits a line into words and removes html tags
	 * @param the line of html you would like to split 
	 * @return A list of words with out the html tags
	 */
	public static List<String> split (String x){
		List<String> sorted = new ArrayList<String>();
		int d = 0;
		while ( !(x.substring(d, d+4).equals("body"))){
			d++;
		}
		x = x.substring(d+4);
		if (x.charAt(d+5) == '{'){
			String y = x.substring(d+5, x.indexOf('}') +1);
			x = x.replace(y, "");
			
		}
		for (int i = 0; i < x.length(); i++){
			
			if (x.charAt(i) == '<'){
				String y = x.substring(i, x.indexOf('>',i) +1);
				x = x.replace(y, "");
				i=-1;
			}
		}
		String[] pre = x.split(" ");
		for (int i = 0; i < pre.length; i++){
			sorted.add(format(pre[i].toLowerCase()));
		}
		return sorted;
	}
	public static String format(String rough) {
		rough = rough.replace(" ", "");
		rough = rough.replace("\"", "");
		rough = rough.replace("(", "");
		rough = rough.replace(")", "");
		rough = rough.replace(",", "");
		rough = rough.replace(":", "");
		rough = rough.replace("^", "");
		rough = rough.replace(";", "");
		rough = rough.replaceAll("\t", "");
		rough = rough.replace(".", "");
		return rough;
	}

}
