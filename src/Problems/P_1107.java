import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class P_1107 {

    boolean[] buttons;
    int moveChannel;
    int moveCnt;

    public void swap(long[] arr, int x, int y) {
        long tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void print(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isBroken(int c) {

        while (c > 0) {
            int channelNum = c % 10;
            if (buttons[channelNum]) {
                return true;
            }
            c /= 10;
        }
        return false;
    }

    public int isLength(int c) {
        int length = 0;
        if (c == 0) {
            if (buttons[c]) {
                //고장났으면
                return 0;
            } else {
                return 1;
            }
        }
        while (c > 0) {
            if (buttons[c % 10]) {
                //고장이 났다면
                return 0;
            }
            length++;
            c /= 10;
        }

        return length;

    }

    public void Solve() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("test.txt");
        Scanner sc = new Scanner(fis);
        //Scanner sc = new Scanner(System.in);
        // System.out.println("long 최댓값 : "+ Long.MAX_VALUE);
        moveChannel = sc.nextInt();
        buttons = new boolean[10];//버튼 고장 유무 True 고장, False 정상작동
        int curChannel = 100;
        int brokenButtonCnt = sc.nextInt();
        while (brokenButtonCnt-- > 0) {
            int button = sc.nextInt();
            buttons[button] = true;
        }
        int checkNum = moveChannel;
        moveCnt = curChannel - moveChannel;
        if (moveCnt < 0) {
            moveCnt *= -1;
        }




        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            int len = isLength(c);
            int minPressBtn = 0;
            if (len > 0) {
                int pressButtonCnt = c - moveChannel;
                if (pressButtonCnt < 0) {
                    pressButtonCnt *= -1;
                }
                minPressBtn = pressButtonCnt + len;
                if (moveCnt > minPressBtn) {
                    moveCnt = minPressBtn;
                }
            }
        }
        System.out.println(moveCnt);
    }

    public static void main(String[] args) throws IOException {
        new P_1107().Solve();
    }
}
