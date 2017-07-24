package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호 : 1789
 * 문제 이름 : 수들의 합
 * 문제 주소 : https://www.acmicpc.net/problem/1789
 */
class P_1789 {

    long findN(long S) {
        long N = 0;
        for (long i = 1; i <= S+1; i++) {
            long sum = i * (i + 1);
            if (sum > 2*S) {
                N = i - 1;
                break;
            }
        }
        return N;
    }

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine().trim());
        System.out.println(findN(S));
    }

    public static void main(String[] args) throws IOException {
        new P_1789().Solve();
    }
}