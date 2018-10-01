import java.io.File;
import java.util.Scanner;

public class DictionaryBuilder {
	private int position = 0;
	private HashTable ht;
	public DictionaryBuilder(HashTable ht, String path) {
		super();
		this.ht = ht;
		new File(path);
		readAndBuild(path);
	}
	public void readAndBuild(String file) {
		Scanner sc = null;
		String tmp;
		try {
			sc = new Scanner(new File(file));
			while(sc.hasNext()) {
				tmp = sc.next();
				add2Dic(tmp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	public void add2Dic(String tmp) {
		if(Hasher.isa2z(tmp)) {
			ht.add(tmp, position, Hasher.hasha2z(tmp));
		}
		else
			M.build.add("ERROR\t"+tmp + "\t\t not a lowercase word");
		position = position + tmp.length() + 1;
	}
}
