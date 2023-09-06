import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, m, circuit;
	
	static boolean visited[];
	static Queue<Integer> qu;
	static ArrayList<Integer> list[];
	static Set<Integer> component;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		qu = new ArrayDeque();
		visited = new boolean [n + 1];
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
		double max = -2147483648;
		Set<Integer> keep = new HashSet();
		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue;
			if (list[i] == null) continue;
			bfs(i);
			double cal = (double)circuit / (double)component.size();
			if (cal == 1) {
				keep = component;
				break;
			}
			if (max < cal) {
				keep = component;
				max = cal;
			}
		}
		List<Integer> sortedList = new ArrayList<>(keep);
		Collections.sort(sortedList);
		for (int i = 0; i < sortedList.size(); i++) {
			sb.append(sortedList.get(i) + " ");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int start) {
		qu.add(start);
		circuit = 0;
		component = new HashSet();
		while (!qu.isEmpty()) {
			int now = qu.poll();
			if (visited[now]) continue;
			if (list[now] == null) continue;
			visited[now] = true;
			component.add(now);
			for (int i = 0; i < list[now].size(); i++) {
				int value = list[now].get(i);
				if (visited[value]) continue;
				circuit++;
				component.add(value);
				qu.add(value);
			}
		}
	}
}
