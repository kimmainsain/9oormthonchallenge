import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long answer[] = new long[] {0, 0};
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> (o2[2] - o1[2]));
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new int [] {a, b, b / a});
		}
		while (!pq.isEmpty()) {
			int now[] = pq.poll();
			if (answer[0] + now[0] < k) {
				answer[0] += now[0];
				answer[1] += now[1];
			} else if (answer[0] + now[0] > k) {
				long t = k - answer[0];
				answer[0] += t;
				answer[1] += t * now[2];
				break;
			} else {
				answer[0] += now[0];
				answer[1] += now[1];
				break;
			}
		}
		System.out.println(answer[1]);
	}
}