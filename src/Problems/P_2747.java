package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 번호 : 2747
 * 문제 이름 : 피보나치 수
 * 문제 주소 : https://www.acmicpc.net/problem/2747
 */
class P_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] fi = new int[n+1];
        fi[0] = 0;
        fi[1] = 1;
        for (int i = 2; i <= n; i++) {
            fi[i] = fi[i - 2] + fi[i - 1];
        }
        System.out.println(fi[n]);
    }
}

