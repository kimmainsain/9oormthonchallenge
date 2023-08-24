import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		count += n / 14;
		n %= 14;
		count += n / 7;
		n %= 7;
		count += n;
		System.out.println(count);
	}
}