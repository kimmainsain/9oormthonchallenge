import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int map[][];
	
	static int dx[] = new int [] {-1,0,1,1,1,0,-1,-1};
	static int dy[] = new int [] {-1,-1,-1,0,1,1,1,0};
	static int n;
	static int m;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int [n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) find(i, j);
			}
		}
		System.out.println(answer);
	}
	
	private static void find(int y, int x) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			int nexty = y + dy[i];
			int nextx = x + dx[i];
			if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
			if (map[nexty][nextx] == 1) count++;
		}
		if (count == m) answer++;
	}
}

