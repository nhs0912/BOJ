package Problems;

import java.io.*;


/**
 * 문제 번호 : 5597
 * 문제 이름 : 과제 안 내신 분..?
 * 문제 주소 : https://www.acmicpc.net/problem/5597
 */
class P_5597 {


    void Solve() throws IOException {
        int[] students = new int[31];
        int N = 28;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (N-- > 0) {

            int num = Integer.parseInt(br.readLine().trim());
            students[num]++;
        }

        for (int i = 1; i < students.length; i++) {
            if (students[i] == 0) {
                bw.write(i + "\n");
            }
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new P_5597().Solve();
    }
}

