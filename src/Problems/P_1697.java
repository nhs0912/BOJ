import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	final int MAX = 1000000;

	class position {
		int site;
		int cnt;

		position(int currentP, int cnt) {
			this.site = currentP;
			this.cnt = cnt;
		}
	}

	public void Solve() {
		Scanner sc = new Scanner(System.in);
		int tracker = sc.nextInt();
		int cow = sc.nextInt();
		int cnt = 0;
		boolean[] visited = new boolean[MAX];

		Queue<position> q = new LinkedList<>();
		position p = new position(tracker, 0);
		q.add(p);
		visited[tracker] = true;
		while (!q.isEmpty()) {
			position curP = q.remove();
			int minusNum = curP.site - 1;
			int plusNum = curP.site + 1;
			int telescopeNum = curP.site * 2;

			if (curP.site == cow) {
				cnt = curP.cnt;
				break;
			}
			if (minusNum >= 0 && !visited[minusNum]) {
				position newP = new position(minusNum, curP.cnt + 1);
				visited[minusNum] = true;
				q.add(newP);
			}

			if (plusNum < MAX && !visited[plusNum]) {
				position newP = new position(plusNum, curP.cnt + 1);
				visited[plusNum] = true;
				q.add(newP);
			}

			if (telescopeNum < MAX && !visited[telescopeNum]) {
				position newP = new position(telescopeNum, curP.cnt + 1);
				visited[telescopeNum] = true;
				q.add(newP);
			}

		}

		System.out.println(cnt);

	}

	public static void main(String[] args) {
		new Main().Solve();
	}
}
