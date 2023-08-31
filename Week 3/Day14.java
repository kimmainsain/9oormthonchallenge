import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static ArrayList<Integer> list[];
	static boolean visited[];
	static int n;
	static int m;
	static int k;
	static int last;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		last = 0;
		int answer = 0;
		visited = new boolean [n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (list[a] == null) {
			   list[a] = new ArrayList();
			}
			if (list[b] == null) {
			   list[b] = new ArrayList();
			}
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			if (list[i] == null) continue;
			Collections.sort(list[i]);
		}
		visited[k] = true;
		dfs(k);
		for (int i = 1; i <= n; i++) {
			// System.out.println(list[i] + " visited : " + visited[i]);
			if (visited[i]) answer++;
		}
		System.out.println(answer + " " + last);
	}
	
	private static void dfs(int start) {
		if (list[start] == null) {
			last = start;
			return;
		}
		for (int i = 0; i < list[start].size(); i++) {
			int now = list[start].get(i);
			if (visited[now]) continue;
			// System.out.println(now);
			visited[now] = true;
			dfs(now);
			return;
		}
		last = start;
	}
}
