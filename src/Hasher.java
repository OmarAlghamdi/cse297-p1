
public class Hasher {
	public static int hasha2z(String str) { // the best
		byte[] arr = str.getBytes();
		int sum = 0, a = 1, b = 0;
		for (int i = 0; i < arr.length; i++) {
			a = a + arr[i] + arr[i%3] + arr[i%5] + arr[i%7];
			b = b + a + arr[i%3] + arr[i%5] ;
		}
		sum = (b << 16) + a ;
		return Math.abs(sum);
	}
	public static boolean isa2z(String str) {
		return str.matches("[a-z]*");
	}
}
