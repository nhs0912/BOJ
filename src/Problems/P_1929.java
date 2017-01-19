package Problems;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2017-01-19
 * 문제 번호 : 1929
 * 문제 이름 : 소수 구하기
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/1929
 */
class P_1929 {

    int[] numbers;
    ArrayList<Integer> primeNumbers = new ArrayList<>();

    boolean isPrimeNumber(int n) {
        if (numbers[n] != 1) {
            //제거 되지 않은 수라면
            for (int i = 0; i < primeNumbers.size(); i++) {
                if (n % primeNumbers.get(i).intValue() != 0) {
                    return true;
                } else {
                    //약수 중에 나누어진다면
                    return false;
                }
            }
        }
        return true;
    }

    void getPrimeNumber(int m) {

        for (int i = 2; i <= m; i++) {
            if (isPrimeNumber(i)) {//소수라면
                primeNumbers.add(i);//add primeNumber in ArrayList.
                for (int j = 2; j * i <= m; j++) {
                    numbers[j * i] = 1;
                }
            }
        }
    }

    void display(int n, int m) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        for (int i = n; i <= m; i++) {
            if (numbers[i] == 0 && i != 1 && i != 0) {
                if (i != m) {
                    //bw.write(Integer.toString(i) + "\n");
                    sb.append(Integer.toString(i) + "\n");
                } else if (i == m) {
                    //bw.write(Integer.toString(i));
                    sb.append(Integer.toString(i));
                }
            }
        }
        System.out.print(sb);
        // bw.close();
    }

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        numbers = new int[m + 1];
        getPrimeNumber(m);
        display(n, m);

    }

    public static void main(String[] args) throws IOException {
        new P_1929().Solve();
    }


}