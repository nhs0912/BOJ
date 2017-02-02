package Problems;

import java.io.*;

/**
 * 문제 번호 : 1003
 * 문제 이름 : 피보나치 함수
 * 문제 주소 : https://www.acmicpc.net/problem/1003
 */


class P_1003 {
    int[] zero = new int[42];
    int[] one = new int[42];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void getNumberCnt(int n) throws IOException {
        zero[0] = 1;
        one[0] = 0;
        zero[1] = 0;
        one[1] = 1;
        zero[2] = one[1];
        one[2] = zero[1] + one[1];

        for (int i = 3; i < zero.length; i++) {
            zero[i] = one[i - 1];
            one[i] = (byte) (zero[i - 1] + one[i - 1]);
        }
        bw.write(zero[n] + " " + one[n] + "\n");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine().trim());
            new P_1003().getNumberCnt(number);
        }
        bw.close();
    }
}

