import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int max[][];
	static int map[][];
	static boolean visited[][];
	static int dy[] = new int [] {0, 1, 0, -1};
	static int dx[] = new int [] {1, 0, -1, 0};
	
	static int n;
	static int k;
	static Queue<int[]> qu;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		qu = new ArrayDeque();
		visited = new boolean [n][n];
		map = new int [n][n];
		max = new int [31][1];
		for (int i = 0; i < 31; i++) {
			max[i][0] = 0;
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) bfs(i, j);
			}
		}

		int answer = -2147483648;
		int check = -2147483648;
		for (int i = 0; i < 31; i++) {
			if (check <= max[i][0]) {
				check = max[i][0];
				answer = i;
			}
		}
		System.out.println(answer);
		// System.out.println(max[0]);
	}
	
	private static void bfs(int y, int x) {
		qu.add(new int [] {y, x});
		visited[y][x] = true;
		int value = map[y][x];
		int count = 1;
		while(!qu.isEmpty()) {
			int now[] = qu.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
				if (visited[nexty][nextx]) continue;
				if (map[nexty][nextx] != value) continue;
				qu.add(new int [] {nexty, nextx});
				visited[nexty][nextx] = true;
				count++;
			}
		}
		// System.out.println("y : " + y + " x : " + x + " count : " + count);
		if (count >= k) {
			max[value][0] += 1;
		}
	}
}

