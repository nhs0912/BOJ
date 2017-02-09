import java.io.*;

/**
 * 문제 번호 : 2193
 * 문제 이름 : 이친수
 * 문제 주소 : https://www.acmicpc.net/problem/2193
 */
class Main {
    boolean checkBinary = true;
    StringBuilder binaryNumber = new StringBuilder();

    int pow(int N) {
        //2의 거듭제곱
        int num = 1;
        for (int i = 0; i < N; i++) {
            num *= 2;
        }
        return num;
    }

    void getBinaryNum(int num) {
        if (num < 2) {
            binaryNumber.append(num);
        } else {
            getBinaryNum(num / 2);
            binaryNumber.append(num % 2);
        }
    }

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int cnt = pow(N);//경우의 수
        String[] binaryNums = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            getBinaryNum(N);
            binaryNums[i] = binaryNumber.toString();
            binaryNumber = new StringBuilder();
        }




        System.out.println(binaryNumber);

    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }
}

