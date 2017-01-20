import java.io.*;
import java.util.ArrayList;

/**
 * 2017-01-20
 * 문제 번호 : 9020
 * 문제 이름 : 골드바흐의 추측
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/9020
 */
class Main {

    int[] numbers;
    ArrayList<Integer> primeNumbers = new ArrayList<>();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int cnt = 0;//PrimeNumber count
    int[] smallPrimeNumber;

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
        cnt = 0;
        System.out.println("소수 갯수 = " + primeNumbers.size());
        System.out.println("primeNumbers ");
        for(int i=0; i<primeNumbers.size();i++)
        {
            System.out.print(primeNumbers.get(i)+" ");
        }
        System.out.println();
        for (int i = n; i <= m; i++) {
            if (numbers[i] == 0 && i != 1 && i != 0) {
                cnt++;
                System.out.print(i + " ");
            }
        }

    }

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = 2;
            int m = Integer.parseInt(br.readLine().trim());
            numbers = new int[m + 1];
            getPrimeNumber(m);
            display(n, m);
        }

        bw.close();

    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();

    }


}