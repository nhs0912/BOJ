package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호 : 2749
 * 문제 이름 : 피보나치 수 3
 * 문제 주소 : https://www.acmicpc.net/problem/2749
 */
class P_2749 {


    int mod = 1000000;
    int p = (mod / 10) * 15; //주기
    int[] memo = new int[p + 1];

    int fibonacci(long num) {
        for (int i = 2; i < p; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            memo[i] %= mod;
        }
        int tmp = (int)(num%p);
        return memo[tmp];
    }

    void Solve() throws IOException {
        memo[0] = 0;
        memo[1] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine().trim());
        System.out.println(fibonacci(num));
    }

    public static void main(String[] args) throws IOException {
        new P_2749().Solve();
    }
}

