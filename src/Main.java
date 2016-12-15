import java.util.Scanner;

public class Main {
    Main() {
        int num = scan();
        String txt = whatFraction(num);
        Print(txt);
    }

    int scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    static String whatFraction(int num) {
        int up = 0; //분자
        int down = 0; //분모
        int n = 1;
        String txt;
        String Fraction;
        //Boolean exitCheck = false;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 != 0) {//홀수 일 때
                    up = i;

                }
                txt = up + "/" + down;
            }
        }

        return txt;
    }

    void Print(String txt) {
        //System.out.println(txt);
    }

    public static void main(String[] args) {
        new Main();
    }
}
