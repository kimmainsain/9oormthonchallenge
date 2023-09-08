import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static ArrayList<ArrayList<Integer>> dfsList;
	static ArrayList<Integer> set;
	static ArrayList<Integer> list[];
	static int n, m, s, e;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dfsList = new ArrayList();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (list[a] == null) list[a] = new ArrayList();
			if (list[b] == null) list[b] = new ArrayList();
			list[a].add(b);
			list[b].add(a);
		}
		set = new ArrayList();
		dfs(s);
		Collections.sort(dfsList, (o1, o2) -> (o1.size() - o2.size()));
		loop : for (int i = 1; i <= n; i++) {
			if (i == s || i == e) {
				sb.append(-1 + "\n");
				continue;
			}
			for (int j = 0; j < dfsList.size(); j++) {
				if (!dfsList.get(j).contains(i)) {
					sb.append(dfsList.get(j).size() + "\n");
					continue loop;
				}
			}
			sb.append(-1 + "\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int value) {
		set.add(value);
		visited[value] = true;
		if (value == e) {
			dfsList.add(new ArrayList(set));
			// System.out.println(set.toString());
			return;
		}
		for (int i = 0; i < list[value].size(); i++) {
			int now = list[value].get(i);
			if (visited[now]) continue;
			visited[now] = true;
			dfs(now);
			visited[now] = false;
			set.remove(set.size() - 1);
		}
	}
}
