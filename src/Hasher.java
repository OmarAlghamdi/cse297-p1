
public class Hasher {
	/*public static int hasha2z1(String str) {
		byte[] arr = str.getBytes();
		int sum = 0, bits = 20;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + (arr[i] << bits);
			bits = bits-4;
			if(bits<=0)
				bits = 20;
		}
		return sum;
	}
	public static int hasha2z2(String str) { // second best
		byte[] arr = str.getBytes();
		int sum = 0, a = 1, b = 0;
		for (int i = 0; i < arr.length; i++) {
			a = a + arr[i];
			b = b + a;
		}
		sum = (b << 16) + a ;
		return sum;
	}*/
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
	/*public static int hasha2z(String str) {
		byte[] arr = str.getBytes();
		int sum = 0, a = 0, b = 0, l = arr.length;
		for (int i = 0; i < arr.length/2; i++) {
			a = a + arr[i] - arr[i%3] + arr[i%5] - arr[i%7] + arr[l-i-1] - arr[l-i%3-1] + arr[l-i%5-1] - arr[l-i%7-1];
			b = b + a - arr[i%3] + arr[i%5] - arr[l-i%3-1] + arr[l-i%5-1];
		}
		
		return Math.abs(sum);
	}*/
	public static boolean isa2z(String str) {
		return str.matches("[a-z]*");
	}
}
