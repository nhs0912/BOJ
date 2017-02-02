package Problems;
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 1009
 * 문제 이름 : 분산처리
 * 문제 주소 : https://www.acmicpc.net/problem/1009
 */
class P_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            //a^b
            int remain = 1;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            remain = a % 10;
            for (int i = 1; i < b; i++) {
                remain = (remain * a) % 10;
            }

            if (remain == 0) {
                bw.write(10 + "\n");
            } else {
                bw.write(remain + "\n");
            }
        }
        bw.close();
    }
}