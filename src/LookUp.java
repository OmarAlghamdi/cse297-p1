import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class LookUp {
	LinkedList<Bucket>[]  ht;
	private File txtFile;
	int b;
	int visited = 0;
	public LookUp(LinkedList<Bucket>[] ht, String probe, int b) {
		this.ht = ht;
		this.b = b;
		readAndLookup(probe);
		//	System.out.println("visited buckets = " +visited);
		M.probe.add("visited buckets = " +visited);
	}
	private void readAndLookup(String probe) {
		Scanner sc = null;
		String tmp;
		try {
			sc = new Scanner(new File(probe));
			while(sc.hasNext()) {
				tmp = sc.next();
				lookup(tmp);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void lookup(String tmp) {
		if(!Hasher.isa2z(tmp))
			//	System.out.println(tmp + "\t\t" + -1 + "\t\t" + 0);
			M.probe.add(tmp + "\t\t" + -1 + "\t\t" + 0);
		else {
			int hash = Hasher.hasha2z(tmp)%b;
			LinkedList<Bucket> ll = ht[hash];
			boolean found = false;
			for (Iterator<Bucket> iterator = ll.iterator(); iterator.hasNext();) {
				Bucket bucket = (Bucket) iterator.next();
				visited++;
				if(bucket.getWord().equals(tmp)) {
					//	System.out.println(tmp + "\t\t" + bucket.getPosition() + "\t\t" + bucket.getCount());
					M.probe.add(tmp + "\t\t" + bucket.getPosition() + "\t\t" + bucket.getCount());
					found = true;
					break;
				}

			}

			if(!found)
				//	System.out.println(tmp + "\t\t" + -1 + "\t\t" + 0);
				M.probe.add(tmp + "\t\t" + -1 + "\t\t" + 0);
		}
	}
}
