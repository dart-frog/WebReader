
public class KeyValuePairs {
	String key;
	String value;
	public KeyValuePairs(String myKey, String myValue){
		key = myKey;
		value = myValue;
	}
	public String getValue(){
		return value;
	}
	public String getKey(){
		return key; 
	}
	public void setValue(String newValue){
		value = newValue;
	}
}
