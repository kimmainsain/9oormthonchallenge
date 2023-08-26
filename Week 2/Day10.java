import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	
	static String inputMap[][];
	static boolean visited[][];
	
	static int n;
	static int count;
	
	static Queue<int[]> qu;
	static int dy[] = new int [] {0, 1, 0, -1};
	static int dx[] = new int [] {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int goormY = Integer.parseInt(st.nextToken()) - 1;
		int goormX = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		int playerY = Integer.parseInt(st.nextToken()) - 1;
		int playerX = Integer.parseInt(st.nextToken()) - 1;
		inputMap = new String [n][n];
		visited = new boolean [n][n];
		qu = new ArrayDeque();
		count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				inputMap[i][j] = st.nextToken();
			}
		}
		find(goormY, goormX);
		int max = count;
		// System.out.println("max : " + max);
		visited = new boolean [n][n];
		count = 0;
		find(playerY, playerX);
		if (max > count) System.out.println("goorm " + max);
		else System.out.println("player " + count);
	}
	
	private static void find(int y, int x) {
		visited[y][x] = true;
		count++;
		qu.add(new int [] {y, x});
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			String order = inputMap[now[0]][now[1]];
			int index = Integer.parseInt(order.substring(0, order.length() - 1));
			char c = order.charAt(order.length() - 1);
			// System.out.println(order);
			if (c == 'R') {
				if (!move(now, index, 0)) break;
			} else if (c == 'D') {
				if (!move(now, index, 1)) break;
			} else if (c == 'L') {
				if (!move(now, index, 2)) break;
			} else if (c == 'U') {
				if (!move(now, index, 3)) break;
			}
		}
	}
	
	private static boolean move(int now[], int index, int dir) {
		int nexty = now[0];
		int nextx = now[1];
		for (int i = 0; i < index; i++) {
			nexty += dy[dir];
			nextx += dx[dir];
			if (nexty < 0) {
				nexty = n - 1;
			} else if (nextx < 0) {
				nextx = n - 1;
			} else if (nexty > n - 1) {
				nexty = 0;
			} else if (nextx > n - 1) {
				nextx = 0;
			}
			if (visited[nexty][nextx] == true) return false;
			visited[nexty][nextx] = true;
			// System.out.println("nexty : " + nexty + " nextx : " + nextx + " count : " + count);
			count++;
		}
		qu.add(new int [] {nexty, nextx});
		return true;
	}
	
}