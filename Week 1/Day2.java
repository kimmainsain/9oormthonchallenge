import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			minute += Integer.parseInt(br.readLine());
		}
		hour += minute / 60;
		minute = minute % 60;
		hour = hour % 24;
		System.out.println(hour + " " + minute);
		
	}
}