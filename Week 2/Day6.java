import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static char arr[];
	static ArrayList<String> list;
	static ArrayList<String[]> threeList;
	static int max;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int len = input.length();
		arr = new char [len];
		list = new ArrayList();
		threeList = new ArrayList();
		max = -2147483648;
		for (int i = 0; i < len; i++) {
			arr[i] = input.charAt(i);
		}
		String a = "";
		for (int j = 0; j < len - 2; j++) {
			String b = "";
			a += arr[j];
			for (int k = j + 1; k < len - 1; k++) {
				String c = "";
				b += arr[k];
				for (int l = k + 1; l < len; l++) {
					c += arr[l];
				}
				threeList.add(new String [] {a, b, c});
				if (!list.contains(a)) list.add(a);
				if (!list.contains(b)) list.add(b);
				if (!list.contains(c)) list.add(c);
			}
		}
		Collections.sort(list);
		cal();
		System.out.println(max);
	}
	
	private static void cal() {
		for (int i = 0; i < threeList.size(); i++) {
			int sum = 0;
			sum += list.indexOf(threeList.get(i)[0]);
			sum += list.indexOf(threeList.get(i)[1]);
			sum += list.indexOf(threeList.get(i)[2]);
			max = Math.max(sum + 3, max);
		}
	}
	