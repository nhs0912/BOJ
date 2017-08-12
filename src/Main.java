
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2606
 * 문제 이름 : 바이러스
 * 문제 주소 : https://www.acmicpc.net/problem/2606
 */

class Main {
    int[][] adjMatrix;
    boolean[][] visited;
    int virusCnt = 0;
    int[][] result;//방문 가능 배열
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }



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

    public void initVisited() {
        for (int i = 1; i < visited.length; i++) {
            for (int j = 1; j < visited[i].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexCnt = Integer.parseInt(br.readLine()); //정점 갯수
        adjMatrix = new int[vertexCnt + 1][vertexCnt + 1]; //인접행렬
        visited = new boolean[vertexCnt + 1][vertexCnt + 1];// 방문 검사
        result = new int[vertexCnt + 1][vertexCnt + 1];// 방문 가능 배열
        int index = 1;
        int N = vertexCnt;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                for (int j = 1; j < vertexCnt + 1; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        adjMatrix[index][j] = num;
                        //adjMatrix[j][index] = num;
                        //visited[index][j] = true;
                        //visited[j][index] = true;
                    } else if (num == 0) {
                        adjMatrix[index][j] = num;
                        //visited[index][j] = true;
                    }
                }
            }
            index++;
        }

        printArr(adjMatrix);
        initVisited();//방문 배열 초기화
    }

    public boolean DFS(int start, int end) {

        for (int i = 1; i < adjMatrix.length; i++) {
            if (adjMatrix[start][i] == 1 && visited[start][i] == false) {
                System.out.print(i + "-> ");
                visited[start][i] = true;
                DFS(i, end);
                if (i == end) {
                    return true;
                }

            }
        }
        System.out.println();
        return false;
    }


    public void checkPath(int start, int end) {
        boolean check = DFS(1, 1);
        System.out.println("check=" + check);
    }

    public void Solve() throws IOException {
        inputData();

        checkPath(1, 1);
//        for (int i = 1; i < adjMatrix.length; i++) {
//            for (int j = 1; j < adjMatrix[i].length; j++) {
//                checkPath(i, j);
//            }
//        }
        System.out.println("result");
        printArr(result);

        //DFS(1);
        // System.out.println(virusCnt);
    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}