import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m;
	static int node[];
	static ArrayList<Integer> list[];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		set();
		// System.out.println(Arrays.toString(node));
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			if (list[b].contains(a)) {
				union(a, b);
			}
			// System.out.println(Arrays.toString(node));
		}
		Set<Integer> set = new HashSet();
		for (int i = 1; i <= n; i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
	}

	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x < y) {
			node[y] = x;
		} else {
			node[x] = y;
		}
	}
	
	public static int find(int value) {
		if (node[value] == value) {
			return value;
		}
		return node[value] = find(node[value]);
	}
	
	public static void set() {
		node = new int [n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			node[i] = i;
			list[i] = new ArrayList();
		}
	}
}
