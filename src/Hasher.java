
public class Hasher {
	public static int hasha2z(String str) {
		byte[] arr = str.getBytes();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}
	public static boolean isa2z(String str) {
		return str.matches("[a-z]*");
	}
}
