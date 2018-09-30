import java.util.LinkedList;

public class BucketList {
	LinkedList<Bucket> buckets;
	public BucketList() {
		buckets = new LinkedList<>();
	}
	public void add(Bucket e) {
		buckets.add(e);
	}
	
}
