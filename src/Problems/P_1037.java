package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문제 번호 : 1037
 * 문제 이름 : 약수
 * 문제 주소 : https://www.acmicpc.net/problem/1037
 */
class P_1037 {

    void swap(int[] arr, int left, int right) {
        //순서 바꾸기
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


    void QuickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = patition(arr, begin, end);
            QuickSort(arr, begin, p - 1);
            QuickSort(arr, p + 1, end);
        }
    }


    int patition(int[] arr, int begin, int end) {//분할
        int right = end;
        int left = begin;
        int pivot = (begin + end) / 2;

        while (left < right) {
            while (arr[left] < arr[pivot] && left < right) {
                left++;
            }

            while (arr[right] >= arr[pivot] && left < right) {
                right--;
            }

            swap(arr, left, right);
            if (left == pivot) {
                pivot = right;
            }
        }

        swap(arr, right, pivot);
        return right;
    }


    void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); //약수 갯수
        int[] divisors = new int[N]; //약수 집합
        int index = 0;
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        while (st.hasMoreTokens()) {//배열에 데이터 넣기
            divisors[index++] = Integer.parseInt(st.nextToken());
        }
        QuickSort(divisors, 0, divisors.length - 1); //정렬
        System.out.println(divisors[0] * divisors[divisors.length - 1]);//처음과 끝 곱하기
    }

    public static void main(String[] args) throws IOException {
        new P_1037().Solve();
    }
}

