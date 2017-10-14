import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Main {
	int[] arr = { 1, 2, 3, 4 };
	int[] numbers;
	int[] permutation;
	int[] result;

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf(arr[i]+" ");
		}
		System.out.println();
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	boolean next_permutation(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i <= 0) {
			return false;
		}
		int j = arr.length - 1;
		while (arr[i - 1] >= arr[j]) {
			// arr[i-1] 보다 큰 수를 찾는다.
			j--;
		}

		swap(arr, i - 1, j);

		j = arr.length - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		// print(arr);
		return true;
	}

	public void solve() throws FileNotFoundException {
		Stack<int[]> s;
		// next_permutation(arr);
		Scanner sc;
		// sc = new Scanner(System.in);
		FileInputStream fis = new FileInputStream("test.txt");
		sc = new Scanner(fis);
		while (true) {
			int N = sc.nextInt();
			//System.out.println("N="+ N);
			if (N == 0) {
				break;
			}
			numbers = new int[N];
			permutation = new int[N];
			result = new int[6];
			s = new Stack();
			int K = N - 6;
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = sc.nextInt();
			}
			for (int i = 0; i < K; i++) {
				permutation[i] = 0;
			}
			for (int i = K; i < numbers.length; i++) {
				permutation[i] = 1;
			}
			do {
				int index = 0;
				for (int i = 0; i < numbers.length; i++) {

					if (permutation[i] == 1) {
						result[index++] = numbers[i];
					}
				}
				// print(result);
				// s.push(result);
				int[] tmpArr = new int[6];
				for (int i = 0; i < tmpArr.length; i++) {
					tmpArr[i] = result[i];
				}
				s.push(tmpArr);
			} while (next_permutation(permutation));

			while (!s.isEmpty()) {
				int[] r = s.pop();
				print(r);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();

	}
}
