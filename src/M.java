import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class M {
	ArrayList<String>errors = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println(Hasher.hasha2z("omar"));
		int b = Integer.parseInt(args[0]);
		HashTable ht = new HashTable(b);
		
		System.out.println();
		System.out.println("================Building=================");
		System.out.println("word\t\t hash");
		
		DictionaryBuilder fp = new DictionaryBuilder(ht, args[1]);
		
		System.out.println();
		System.out.println("================Lookup=================");
		System.out.println("word\t\tlocation\t\tcount");
		LookUp lu = new LookUp(ht.getBuckets(), args[2], b);
		
		int[] bucketSize = new int[b];
		LinkedList<Bucket>[] bc = ht.getBuckets();
		double sum = 0;
		for (int i = 0; i < bucketSize.length; i++) {
			bucketSize[i] = bc[i].size();
			sum = sum + bc[i].size();
		}
		double avgSize = sum/b, tss = 0;
		for (int i = 0; i < bucketSize.length; i++) {
			tss = tss + Math.pow(bucketSize[i]-avgSize, 2);
		}
		System.out.println(avgSize);
		System.out.println("sum of squares = " + tss);
		
		/*LinkedList<Bucket>[] bc = ht.getBuckets();
		for (int i = 0; i < bc.length; i++) {
			for (Iterator iterator = bc[i].iterator(); iterator.hasNext();) {
				Bucket bucket = (Bucket) iterator.next();
				System.out.println(bucket.toString() + i);
			}
		}*/

	}

}
