import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int m;
	static char inputMap[][];
	static int answerMap[][];
	
	static int dx[] = new int [] {0, -1, 0, 1, 0};
	static int dy[] = new int [] {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		inputMap = new char [n][n];
		answerMap = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				String s = st.nextToken();
				inputMap[i][j] = s.charAt(0);
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			find(y, x);
		}
		
		int max = -2147483648;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, answerMap[i][j]);
			}
		}
		System.out.println(max);
	}
	
	private static void find(int y, int x) {
		for (int i = 0; i < 5; i++) {
			int nexty = y + dy[i];
			int nextx = x + dx[i];
			if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
			if (inputMap[nexty][nextx] == '#') continue;
			if (inputMap[nexty][nextx] == '@') answerMap[nexty][nextx] += 2;
			if (inputMap[nexty][nextx] == '0') {
				answerMap[nexty][nextx] += 1;
			}
		}
	}
}
