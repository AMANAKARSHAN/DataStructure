package Queue;
import java.util.*;

class CacheEntry{
	int key;
	String value;
	
	CacheEntry(int key, String value){
		this.key=key;
		this.value=value;
	}
}

public class LruImplementation {

	Deque<CacheEntry> dq = new LinkedList<>();
	Map<Integer,CacheEntry> mp = new HashMap<>();
	int CACHE_SIZE;
	
	LruImplementation(int size){
		CACHE_SIZE = size;
	}
	
	public String getFromCache(int key) {
		if(mp.containsKey(key)) {
		CacheEntry entry = mp.get(key);
			dq.remove(entry);
			dq.addFirst(entry);
			return entry.value;
		}
		
		return null;
		
	}
	
	public void putEntryIntoCache(int key,String value) {
		if(mp.containsKey(key)){
			CacheEntry entry = mp.get(key);
			dq.remove(entry);
			dq.addFirst(entry);
			
		}else {
			if(dq.size()==CACHE_SIZE) {
				CacheEntry entryToBeRemove = dq.removeLast();
				mp.remove(entryToBeRemove.key);
			}
		}
		
		CacheEntry newEntry= new CacheEntry(key,value);
		dq.addFirst(newEntry);
		mp.put(key,newEntry);
	}
	
	public static void main(String args) {
		LruImplementation cache = new LruImplementation(3);
		cache.putEntryIntoCache(1, " Product-1-info");
		cache.putEntryIntoCache(2, " Product-2-info");
		cache.putEntryIntoCache(3, " Product-3-info");
		cache.putEntryIntoCache(4, " Product-4-info");
		
		
		//System.out.println(cache.getFromCache(6));
		System.out.println(cache.getFromCache(1));
		
	}
	
	
}
