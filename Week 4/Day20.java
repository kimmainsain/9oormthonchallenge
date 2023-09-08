import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int dy[] = new int [] {0, 1, 0, -1};
	static int dx[] = new int [] {1, 0, -1, 0};
	
	static Queue<int []> qu;
	static boolean visited[][];
	static int n, m, k;
	static char map[][];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		qu = new ArrayDeque();
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			char c = st.nextToken().charAt(0);
			visited = new boolean[n][n];
			map[y][x] = c;
			bfs(y, x);
			// System.out.println(Arrays.deepToString(map));
		}
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int y, int x) {
		char c = map[y][x];
		qu.add(new int [] {y, x});
		visited[y][x] = true;
		int count = 1;
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
				if (map[nexty][nextx] != c) continue;
				if (visited[nexty][nextx]) continue;
				visited[nexty][nextx] = true;
				qu.add(new int [] {nexty, nextx});
				count++;
			}
		}
		if (count >= k) {
			qu.add(new int [] {y, x});
			while (!qu.isEmpty()) {
				int now[] = qu.poll();
				for (int i = 0; i < 4; i++) {
					int nexty = now[0] + dy[i];
					int nextx = now[1] + dx[i];
					if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
					if (!visited[nexty][nextx]) continue;
					visited[nexty][nextx] = false;
					map[nexty][nextx] = '.';
					qu.add(new int [] {nexty, nextx});
				}
			}
		}
		// System.out.println(count);
	}
}
