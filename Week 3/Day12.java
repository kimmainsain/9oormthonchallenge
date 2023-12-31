import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int map[][];
	static boolean visited[][];
	
	static Queue<int[]> qu;
	static int dy[] = new int [] {0, 1, 0, -1};
	static int dx[] = new int [] {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		visited = new boolean [n][n];
		qu = new ArrayDeque();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					// System.out.println("i : " + i + " j : " + j);
					count++;
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
	}
	
	private static void bfs(int y, int x) {
		visited[y][x] = true;
		qu.add(new int [] {y, x});
		while(!qu.isEmpty()) {
			int now[] = qu.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
				if (visited[nexty][nextx]) continue;
				if (map[nexty][nextx] == 0) continue;
				qu.add(new int [] {nexty, nextx});
				visited[nexty][nextx] = true;
			}
		}
	}
}

