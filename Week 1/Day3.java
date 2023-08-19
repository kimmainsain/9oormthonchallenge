import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String buho = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			if ("+".equals(buho)) {
				answer += a + b;
			} else if ("-".equals(buho)) {
				answer += a - b;
			} else if ("*".equals(buho)) {
				answer += a * b;
			} else if ("/".equals(buho)) {
				answer += a / b;
			}
		}
		System.out.println(answer);
		
	}
}