import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Queue<int[]> qu = new ArrayDeque();
		boolean visited[] = new boolean [1000001];
		qu.add(new int [] {n, 0});
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			if (now[0] == 0) {
				System.out.println(now[1]);
				return;
			}
			if (now[0] - a >= 0 && !visited[now[0] - a]) {
				visited[now[0] - a] = true;
				qu.add(new int [] {now[0] - a, now[1] + 1});
			}
			if (now[0] - b >= 0 && !visited[now[0] - b]) {
				visited[now[0] - b] = true;
				qu.add(new int [] {now[0] - b, now[1] + 1});
			}
		}
		System.out.println("-1");
	}
}