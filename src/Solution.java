import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 코드그라운드
 * "김씨만 행복한 세상"
 */
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */


class myQueue {
    int size;
    int[] arr;
    int front = 0;
    int rear = 0;

    myQueue(int size) {
        this.size = size;
        arr = new int[size + 1];
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return front == (arr.length - 1);
    }

    void enQueue(int data) {
        if (!isFull()) {
            arr[front++] = data;
        }
    }

    int deQueue() {
        if (!isFull()) {
            return arr[rear++];
        } else {
            return 0;
        }
    }


}

class Solution {
    //static int Answer;
    int[][] adjMatrix;
    boolean[] visited;
    char[] markedZone;
    myQueue q;
    int zoneCnt;

    void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printArr(boolean[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printArr(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void initMarkedZone() {
        //'A' , 'B', 'N'
        for (int i = 1; i < markedZone.length; i++) {
            markedZone[i] = 'N';
        }
    }

    void BFS(int start) {

        visited[start] = true;
        q.enQueue(start);
        while (!q.isEmpty()) {
            int here = q.deQueue();
            System.out.print(here + "->");
            for (int there = 1; there <= zoneCnt; there++) {
                if (visited[there] || (adjMatrix[here][there] != 1)) {
                    continue;
                }
                visited[there] = true;
                q.enQueue(there);
            }
        }

    }

    public void solve() throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            boolean isCheck = false;
            zoneCnt = sc.nextInt();// 지역의 갯수
            int adjZoneCnt = sc.nextInt();// 인접한 지역의 갯수
            adjMatrix = new int[zoneCnt + 1][zoneCnt + 1];
            visited = new boolean[zoneCnt + 1];
            markedZone = new char[zoneCnt + 200];
            q = new myQueue(zoneCnt + 1);
            initMarkedZone();
            int index = 0;

            while (adjZoneCnt-- > 0) {
                int neighborZone1 = sc.nextInt();
                int neighborZone2 = sc.nextInt();
                adjMatrix[neighborZone1][neighborZone2] = 1;
            }
            BFS(1);


//            System.out.println("Case #" + (test_case + 1));
//
//            if (!isCheck) {
//                System.out.println(1);
//            } else {
//                System.out.println(0);
//            }

        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().solve();

    }
}