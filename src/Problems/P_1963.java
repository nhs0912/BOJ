import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_1963 {
	boolean[] primeNum = new boolean[10001];

	void print(boolean[] arr) {
		for (int i = 2; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.printf("%8b", arr[i]);
		}
		System.out.println();
	}

	public void findPrimeNumber() {
		for (int i = 2; i < 10001; i++) {
			for (int j = i * i; j < 10001; j += i) {
				if (!primeNum[i]) {
					// 소수가 아닌 부분을 true로 바꾼다.
					primeNum[j] = true;
				}
			}
		}

		for (int i = 0; i < primeNum.length; i++) {
			primeNum[i] = !primeNum[i];
		}
	}

	public boolean isPrimeNum(int num) {
		// 소수 이면 true, 아니면 false
		return primeNum[num];
	}

	public static int change(int num, int index, int digit) {
		if (index == 0 && digit == 0) {
			// 처음 자릿수(1000의 자리)가 0일 경우
			return -1;
		}
		String s = Integer.toString(num);// change integer to string
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index, (char) (digit + '0'));
		return Integer.parseInt(sb.toString());
	}

	public void Solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		findPrimeNumber();
		boolean[] visited;
		int[] distance;

		while (N-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			visited = new boolean[10001];// 이미 수행하였는지 구분
			distance = new int[10001];// 거리 재기
			Queue<Integer> q = new LinkedList<Integer>();
			visited[start] = true;
			q.add(start);
			while (!q.isEmpty()) {
				int qNum = q.remove();

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j <= 9; j++) {
						int checkNum = change(qNum, i, j);

						if (checkNum != -1 && isPrimeNum(checkNum) && !visited[checkNum]) {
							// 소수이면서 이미 체크하지 않은 수를 Queue에 넣는다.
							q.add(checkNum);
							distance[checkNum] = distance[qNum] + 1;
							visited[checkNum] = true;
						}
					}
				}
			}
			System.out.println(distance[end]);
		}

	}

	public static void main(String[] args) {
		new P_1963().Solve();
	}
}
