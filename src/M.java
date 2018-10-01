import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class M {
	static ArrayList<String>build = new ArrayList<>();
	static ArrayList<String>probe = new ArrayList<>();
	static ArrayList<String>hashTable = new ArrayList<>();
	
	public static void printBuildReport() {
		for (Iterator<String> iterator = build.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
	public static void printProbeReport() {
		for (Iterator<String> iterator = probe.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
	public static void printHashTableReport() {
		for (Iterator<String> iterator = hashTable.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
	
	public static void main(String[] args) {
		int b = Integer.parseInt(args[0]);
		HashTable ht = new HashTable(b);
		
	//	System.out.println();
	//	System.out.println("================Building=================");
	//	System.out.println("word\t\t hash");
		build.add("================Build Report=================");
		build.add("word\t\t hash");
		DictionaryBuilder fp = new DictionaryBuilder(ht, args[1]);
		
	//	System.out.println();
	//	System.out.println("================Lookup=================");
	//	System.out.println("word\t\tlocation\t\tcount");
		probe.add("================Probe Report=================");
		probe.add("word\t\tlocation\t\tcount");
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
		hashTable.add("================Hash Table Report=================");
	//	System.out.println(avgSize);
	//	System.out.println("sum of squares = " + tss);
		hashTable.add("sum of squares = " + tss);
		/*LinkedList<Bucket>[] bc = ht.getBuckets();
		for (int i = 0; i < bc.length; i++) {
			for (Iterator iterator = bc[i].iterator(); iterator.hasNext();) {
				Bucket bucket = (Bucket) iterator.next();
				System.out.println(bucket.toString() + i);
			}
		}*/
		Scanner in = new Scanner(System.in);
		while(true) {
			switch (in.nextLine()) {
			case "build report":
				M.printBuildReport();
				break;
			case "probe report":
				M.printProbeReport();
				break;
			case "hash table report":
				M.printHashTableReport();
				break;
			case "exit":
				System.exit(0);
			}
			
		}
		
		
	}

}
