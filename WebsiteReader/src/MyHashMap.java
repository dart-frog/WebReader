import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyHashMap {
	List<KeyValuePairs>[] myHashMap;
	
	@SuppressWarnings("unchecked")
	public MyHashMap(int numberOfBuckets){
		myHashMap = new ArrayList[numberOfBuckets];
		for(int i = 0; i < numberOfBuckets; i++){
			myHashMap[i] = new ArrayList<KeyValuePairs>();
		}
		
	} 
	/**
	 * Adds a key value pair to the hash map
	 * @param key sets the key of the KeyValuePair
	 * @param value sets the value of the KeyValuePair
	*/
	public void set(String key, String value){
		int bin = hash(key);
		KeyValuePairs x = new KeyValuePairs(key,value);
		myHashMap[bin].add(x);
		x.getValue();
	}
	public void change(String key, String newValue){
		int bin = hash(key);
		List<KeyValuePairs> l = myHashMap[bin];
		int i = 0;
		while(i < l.size()){
		String myX =l.get(i).getKey();
			if (myX.equals(key)){
				l.get(i).setValue(newValue);
			}
			i++;
		}
	}
	/**
	 * Returns the value of a given key
	 * @param key is the value you are looking for 
	 * @return the value connected with the key or null if it is not found
	 */
	public String get(String key){
		int bin = hash(key), n=0;
		List<KeyValuePairs> l = myHashMap[bin];
		Iterator<KeyValuePairs> listIter = l.iterator();
		KeyValuePairs kvp;
		String myX;
		while(listIter.hasNext()){
			kvp = listIter.next();
			myX = kvp.getKey();
			if(key.equals("surrounded")) {
				n++;
			}
			if(myX.equals(key)) {
				return kvp.getValue();
			}
		}
		return null;
	}
	/**
	 * Returns a list of all the keys in the hash map
	 * @return the list holding all of the keys.
	 */
	public List<String> getKeys(){
		ArrayList<String> xList = new ArrayList<String>();
		for (int i = 0; i < myHashMap.length; i++){
			for (int y = 0; y < myHashMap[i].size();y++){
				String myKey = myHashMap[i].get(y).getKey();
				xList.add(myKey);
			}
		
		}
		return xList;
		
	}
	/**
	 * Returns whether a certain key exists inside the hash map
	 * @param key is the key that you are searching for
	 * @return if a match is found it will return true if not it will return false
	 */
	public boolean exists(String key){
		for (int i = 0; i < myHashMap.length; i++){
			for (int y = 0; y < myHashMap[i].size(); y++){
				String myKey = myHashMap[i].get(y).getKey();
				if (key.equals(myKey)){
					return true;
				}
			}
		}
		return false;
	}
	public int size(){
		return myHashMap.length;
	}
	public int bucketSize(int b){
		return myHashMap[b].size();
	}
	public int hash(String s) {
		return s.length() % 10;
	}
	public int getBucket(String key){
		for (int i = 0; i < myHashMap.length; i++){
			for (int y = 0; y < myHashMap[i].size();y++){
				String myKey = myHashMap[i].get(y).getKey();
				if (key.equals(myKey)){
					return i;
				}
			}
		}
		return 0;
	}
	
	
	
}
