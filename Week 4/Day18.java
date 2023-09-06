import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m;
	static int dx[] = new int [] {1, 0, -1, 0};
	static int dy[] = new int [] {0, 1, 0, -1};
	static int mapUD[][];
	static int mapLR[][];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mapUD = new int [n][n];
		mapLR = new int [n][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			String s = st.nextToken();
			int dir = "RDLU".indexOf(s);
			cal(y, x, dir);
		}
		long answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mapLR[i][j] != 0 && mapUD[i][j] != 0) answer += (long)mapLR[i][j] * (long)mapUD[i][j];
			}
		}
		System.out.println(answer);
	}
	
	private static void cal(int y, int x, int dir) {
		Queue<int []> qu = new ArrayDeque();
		qu.add(new int [] {y, x});
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			if (now[0] < 0 || now[0] > n - 1 || now[1] < 0 || now[1] > n - 1) continue;
			if (dir == 0 || dir == 2) mapLR[now[0]][now[1]]++;
			else mapUD[now[0]][now[1]]++;
			qu.add(new int [] {now[0] + dy[dir], now[1] + dx[dir]});
		}
	}
}
