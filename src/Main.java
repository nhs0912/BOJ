
import java.io.*;
import java.util.StringTokenizer;


class Main {
    int[][] zone;
    boolean[][] visited;
    boolean[][] safeZone;

    public void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void printMatrix(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void searchSafeZone(int num) {//침수구간 찾기
        for (int i = 0; i < safeZone.length; i++) {
            for (int j = 0; j < safeZone[i].length; j++) {
                if (num >= zone[i][j]) {
                    safeZone[i][j] = true;//침수 구간
                }
            }
        }
    }

    public void countSafeZone() {
        //안전구역 갯수 카운트
        for(int i=0; i<safeZone.length;i++) {
            for(int j=0;j<safeZone[i].length;j++)
            {

            }
        }
    }


    public void Solve() throws IOException {

        FileInputStream fis = new FileInputStream("test.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int bigSize = 0;
        zone = new int[N][N];
        visited = new boolean[N][N];
        safeZone = new boolean[N][N];
        int i = 0;
        while (N-- > 0) {//input data
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                zone[i][index++] = num;
                if (bigSize < num) {
                    bigSize = num;
                }
            }
            i++;
        }

        printMatrix(zone);
        searchSafeZone(3);
        printMatrix(safeZone);

    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}