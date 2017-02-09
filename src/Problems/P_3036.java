package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문제 번호 : 3036
 * 문제 이름 : PRSTENI
 * 문제 주소 : https://www.acmicpc.net/problem/3036
 */
class P_3036 {

    int gcd(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }


    void Solve() throws IOException {
       // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int criterion = Integer.parseInt(st.nextToken()); //기준 톱니 바퀴
        int[] wheel = new int[N - 1];
        int index = 0;
        while (st.hasMoreTokens()) {
            wheel[index++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < wheel.length; i++) {
            int gcdNum = gcd(criterion, wheel[i]);
            System.out.println(criterion / gcdNum + "/" + wheel[i] / gcdNum);
            //bw.write(criterion / gcdNum + "/" + wheel[i] / gcdNum+"\n");
        }

       // bw.close();

    }

    public static void main(String[] args) throws IOException {
        new P_3036().Solve();
    }
}

