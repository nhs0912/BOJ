package Problems;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 문제 번호 : 1629
 * 문제 이름 : 곱셈
 * 문제 주소 : https://www.acmicpc.net/problem/1629
 */
class P_1629 {
    static long c;

    public static long pow(long a, long b) {
        long x = 0;
        if (b == 1) {
            return a % c;
        } else if ((b % 2) == 0) {
            x = pow(a, b / 2);
            return (x * x) % c;
        } else {
            return (a * pow(a, b - 1)) % c;
        }
    }


    void Solve(long a, long b) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.toString(pow(a, b)));
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        new P_1629().Solve(a, b);
    }
}

