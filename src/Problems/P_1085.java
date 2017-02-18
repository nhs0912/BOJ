package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 1085
 * 문제 이름 : 직사각형에서 탈출
 * 문제 주소 : https://www.acmicpc.net/problem/1085
 */
class P_1085 {

    int distance(int x1, int y1, int x2, int y2) {
        int result = 0;
        if (x1 == x2) {
            result = y2 - y1;
        } else {
            result = x2 - x1;
        }
        if (result < 0) {
            result *= -1;
        }
        return result;
    }


    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] testX = new int[4];
        int[] testY = new int[4];
        boolean first = true;
        int minDistance = 0;
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        testX[0] = x;
        testY[0] = 0;

        testX[1] = x;
        testY[1] = h;

        testX[2] = 0;
        testY[2] = y;

        testX[3] = w;
        testY[3] = y;


        for (int i = 0; i < testX.length; i++) {
            if (first) {
                minDistance = distance(x, y, testX[i], testY[i]);
                first = false;
            }
            int distance = distance(x, y, testX[i], testY[i]);
            if (minDistance > distance) {
                minDistance = distance;
            }
        }
        System.out.println(minDistance);


    }

    public static void main(String[] args) throws IOException {
        new P_1085().Solve();
    }
}

