
public class Bucket {
	private String word;
	private int position;
	private int count;
	public Bucket(String word, int position) {
		super();
		this.word = word;
		this.position = position;
		this.count = 1;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWord() {
		return word;
	}
	public int getPosition() {
		return position;
	}
	@Override
	public String toString() {
		return word + "\t\t";
	}
	
}
