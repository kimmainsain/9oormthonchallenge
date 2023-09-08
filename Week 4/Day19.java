import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static ArrayList<Integer> list[];
	static Queue<int[]> qu;
	static boolean visited[];
	static int n, m, s, e;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (list[a] == null) list[a] = new ArrayList();
			if (list[b] == null) list[b] = new ArrayList();
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			visited[i] = true;
			bfs();
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		qu = new ArrayDeque();
		qu.add(new int [] {s, 1});
		while(!qu.isEmpty()) {
			int now[] = qu.poll();
			if (now[0] == e) {
				sb.append(now[1] + "\n");
				return;
			}
			if (visited[now[0]]) continue;
			visited[now[0]] = true;
			for (int i = 0; i < list[now[0]].size(); i++) {
				int next = list[now[0]].get(i);
				if (visited[next]) continue;
				qu.add(new int [] {next, now[1] + 1});
			}
		}
		sb.append(-1 + "\n");
	}
}
