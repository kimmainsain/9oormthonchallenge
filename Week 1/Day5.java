import java.io.*;
import java.util.*;

class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int m;
	static PriorityQueue<int[]> pq;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o2[0] - o1[0];
			} else {
				return o2[1] - o1[1];
			}
		});
		
		for (int i = 0; i < n; i++) {
			toBinary(Integer.parseInt(st.nextToken()));
		}
		
		int now[];
		while (--m > 0) {
			now = pq.poll();
		}
		now = pq.poll();
		System.out.println(now[0]);
	}
	
	private static void toBinary(int value) {
		int keepValue = value;
		int count = 0;
		while(value > 0) {
			if (value % 2 == 1) {
				count++;
			}
			value /= 2;
		}
		pq.add(new int [] {keepValue, count});
	}
}