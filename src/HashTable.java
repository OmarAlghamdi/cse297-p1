import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {
	private LinkedList<Bucket>[] buckets;
	private int b;
	public HashTable(int b) {
		this.b = b;
		buckets = new LinkedList[b];
		initialize();
	}
	private void initialize() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}
	public void add(String word, int position, int hash) {
		int bLoc = hash % b;
		LinkedList<Bucket> llB = buckets[bLoc];
		boolean exist = false;
		try {
			for (Iterator<Bucket> iterator = llB.iterator(); iterator.hasNext();) {
				Bucket bucket = (Bucket) iterator.next();
				if(bucket.getWord().equals(word)) {
					exist = true;
					M.build.add("ERROR\t" + word + "\t\t duplicte");
					bucket.setCount(bucket.getCount()+1);
					break;
				}
			}
		}
		catch(NullPointerException e) {
			llB = new LinkedList<>();
		}
		if(!exist) {
			llB.add(new Bucket(word, position));
			M.build.add(word + "\t\t" + bLoc);
		}
	}
	public LinkedList<Bucket>[] getBuckets() {
		return buckets;
	}
}
