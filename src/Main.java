import java.io.*;

/**
 * 문제 번호 : 2442
 * 문제 이름 : 별찍기 - 5
 * 문제 주소 : https://www.acmicpc.net/problem/2442
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int range = 2 * n - 1;
        for (int i = 0;i<range;i++ )
        {
            System.out.printf("%c", '*');
        }

    }
}

