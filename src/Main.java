
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2910
 * 문제 이름 : 빈도정렬
 * 문제 주소 : https://www.acmicpc.net/problem/2910
 */


class Number {
    int num; //숫자
    int firstIndex; //처음 나온 주소
    int cnt; //빈도수

    Number(int num, int firstIndex, int cnt) {
        this.num = num;
        this.firstIndex = firstIndex;
        this.cnt = cnt;
    }
}

class MergeSort {
    Number[] sorted;

    MergeSort(int size) {
        sorted = new Number[size];
    }

    public void sortCnt(int begin, int end, Number[] arr) {
        int mid;
        if (begin < end) {
            mid = (begin + end) / 2;
            sortCnt(begin, mid, arr);
            sortCnt(mid + 1, end, arr);
            mergeCnt(begin, mid, end, arr);
        }
    }

    public void sortOrder(int begin, int end, Number[] arr) {
        int mid;
        if (begin < end) {
            mid = (begin + end) / 2;
            sortOrder(begin, mid, arr);
            sortOrder(mid + 1, end, arr);
            mergeOrder(begin, mid, end, arr);
        }
    }

    void mergeCnt(int begin, int middle, int end, Number[] arr) {
        int left = begin;
        int right = middle + 1;
        int index = begin;
        while (left <= middle && right <= end) {
            if (arr[left].cnt < arr[right].cnt) {
                sorted[index] = arr[right++];
            } else {
                sorted[index] = arr[left++];
            }
            index++;
        }

        while (left <= middle && right > end) {
            sorted[index++] = arr[left++];

        }
        while (left > middle && right <= end) {
            sorted[index++] = arr[right++];
        }

        for (int i = begin; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }

    void mergeOrder(int begin, int middle, int end, Number[] arr) {
        int left = begin;
        int right = middle + 1;
        int index = begin;
        while (left <= middle && right <= end) {
            if (arr[left].firstIndex <= arr[right].firstIndex) {
                sorted[index] = arr[left++];
            } else {
                sorted[index] = arr[right++];
            }
            index++;
        }

        while (left <= middle && right > end) {
            sorted[index++] = arr[left++];
        }
        while (left > middle && right <= end) {
            sorted[index++] = arr[right++];
        }

        for (int i = begin; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }

    public void initSorted() {
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = null;
        }
    }
}

class Main {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Number[] numberList;

    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fastPrintArr(int[][] arr) throws IOException {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");

            }
            bw.write("\n");
        }
        bw.close();
    }

    public void printArr(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
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


    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// message length
        int C = Integer.parseInt(st.nextToken());//숫자 범위
        int[][] numCnt = new int[3][N + 1];//빈도 수 저장
        int[] numFirstIndex = new int[N + 1];// 숫자 처음 출현
        boolean[] numVisited = new boolean[N + 1]; //처음 숫자인지 검사
        st = new StringTokenizer(br.readLine());
        int index = 1;
        //int firstIndex = Integer.MAX_VALUE;
        numberList = new Number[C + 1];
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (numVisited[num] != true) {
                numCnt[1][index] = num;
                numFirstIndex[num] = index++;
                numVisited[num] = true;
            }
            for (int i = 1; i < numCnt[1].length; i++) {
                if (numCnt[1][i] == num) {
                    numCnt[2][i]++;
                }
            }

        }


        for (int i = 1; i < numCnt.length; i++) {
            int number = i;
            int firstIndex = numFirstIndex[i];
            //int cnt = numCnt[i];
            //Number num = new Number(number, firstIndex, cnt);
            // numberList[i] = num;
        }
        printArr(numCnt);

//        System.out.println("시작");
//        for (int i = 1; i < numCnt[0].length; i++) {
//            if (numCnt[1][i] != 0) {
//                for (int j = 0; j < numCnt[2][i]; j++) {
//                    System.out.print(numCnt[1][i] + " ");
//                }
//            } else {
//                break;
//            }
//        }
//        System.out.println();
//        printArr(numFirstIndex);
    }

    public void printSortList() throws IOException {
        for (int i = 1; i < numberList.length; i++) {
            for (int j = 0; j < numberList[i].cnt; j++) {
                //System.out.print(numberList[i].num + " ");
                bw.write(numberList[i].num + " ");
            }
        }
        // System.out.println();
        bw.close();
    }

    public void Solve() throws IOException {
        inputData();
//        MergeSort m = new MergeSort(numberList.length);
//        m.sortOrder(1, numberList.length - 1, numberList);
//        m.sortCnt(1, numberList.length - 1, numberList);
//        printSortList();
    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}