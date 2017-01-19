package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2017-01-17
 * 문제 번호 : 1978
 * 문제 이름 : 소수 찾기
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/1978
 */


class P_1978 {
    boolean isPrimeNumber(int number) {

        if (number == 1 || number == 0) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine().trim());

        int primeNumberCnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        while (st.hasMoreTokens()) {
            boolean isPrime = new P_1978().isPrimeNumber(Integer.parseInt(st.nextToken()));

            if (isPrime) {//소수라면
                primeNumberCnt++;
            }
        }
        bw.write(Integer.toString(primeNumberCnt));
        bw.close();


    }
}