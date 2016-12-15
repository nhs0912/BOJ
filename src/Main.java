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
        if(num%10!=0) {
            up = (num / 10) + 1;
            down = num % 10;
        }
        else{//10의 배수이면
            up=num/10;
            down=10;
        }
        String txt = up + "/" + down;
        return txt;
    }
    void Print(String txt) {
        System.out.println(txt);
    }
    public static void main(String[] args) {
        new Main();
    }
}
