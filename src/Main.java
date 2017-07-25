
import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 10942
 * 문제 이름 : 팰린드롬?
 * 문제 주소 : https://www.acmicpc.net/problem/10942
 */


class Main {
    int[] data;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void findPalindrome(int start, int end) throws IOException {
        if (start == end) {
            bw.write("1\n");

            //System.out.println("똑같다");
        } else {
            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }


            int mid = (start + end) / 2;
            boolean check = true;
            for (int i = start; i <= mid; i++) {
                if (data[i] != data[end - i + 1]) {
                    check = false;
                }
            }

            if (check) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }

        }
    }

    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        data = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()) {
            data[index++] = Integer.parseInt(st.nextToken());
        }
        // printArr(data);
        int qCnt = Integer.parseInt(br.readLine());
        while (qCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            findPalindrome(start, end);
        }

        bw.close();
    }


    public void Solve() throws IOException {
        inputData();

    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}