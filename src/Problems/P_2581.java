package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 2017-01-19
 * 문제 번호 : 2581
 * 문제 이름 : 소수
 * 문제 사이트 주소 : https://www.acmicpc.net/problem/2581
 */
class P_2581 {

    int[] numbers;
    ArrayList<Integer> primeNumbers = new ArrayList<>();
    int sum = 0;

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
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       // StringBuffer sb = new StringBuffer();
        int firstPrimeNumber = 0;
        boolean isFirst = true;
        boolean existPrimeNumber = false;
        for (int i = n; i <= m; i++) {
            if (numbers[i] == 0 && i != 1 && i != 0) {
                if (isFirst) {
                    firstPrimeNumber = i;
                    isFirst = false;
                    existPrimeNumber=true;
                }
                sum += i;
            }
        }
        if(existPrimeNumber) {
            System.out.println(sum);
            System.out.println(firstPrimeNumber);
        }else{
            System.out.println(-1);
        }

    }

    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        numbers = new int[m + 1];
        getPrimeNumber(m);
        display(n, m);

    }

    public static void main(String[] args) throws IOException {
        new P_2581().Solve();
    }


}