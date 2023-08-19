import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		double answer = w * (double)((double)1 + (double)r / (double)30);
		System.out.println((int)answer);
	}
}