import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int [n];
		int sum = 0;
		int max = -2147483648;
		int maxIdx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			if (arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		
		if (maxIdx == 0) {
			if (!rightCal(arr, arr[maxIdx], maxIdx + 1, n)) {
				return;
			}
			System.out.println(sum);
			return;
		}
		
		if (maxIdx == n - 1) {
			if (!leftCal(arr, arr[maxIdx], maxIdx - 1)) {
				return;
			}
			System.out.println(sum);
			return;
		}
		
		if (!leftCal(arr, arr[maxIdx - 1], maxIdx - 1) || !rightCal(arr, arr[maxIdx + 1], maxIdx + 1, n)) {
			return;
		}
		
		System.out.println(sum);
	}
	
	private static boolean leftCal(int arr[], int maxValue, int index) {
		while (index >= 0) {
			if (arr[index] > maxValue) {
				System.out.println(0);
				return false;
			}
			maxValue = arr[index];
			index--;
		}
		return true;
	}
	private static boolean rightCal(int arr[], int maxValue, int index, int n) {
		while (index < n) {
			if (arr[index] > maxValue) {
				System.out.println(0);
				return false;
			}
			maxValue = arr[index];
			index++;
		}
		return true;
	}
}