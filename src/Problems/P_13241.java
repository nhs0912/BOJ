package Problems;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 문제 번호 : 13241
 * 문제 이름 : 최소공배수
 * 문제 주소 : https://www.acmicpc.net/problem/13241
 */
class P_13241 {

    long gcd(long x, long y) {
        if (x < y) {
            long tmp = x;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long gcdNum = gcd(x, y); //최대공약수
        long lcm = x * y / gcdNum; //최소공배수
        bw.write(lcm + "\n");
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        new P_13241().Solve();
    }
}
