package Problems;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by nhs0912 on 2016-12-15.
 */
public class P_10039 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int score = 0;
        for (int i = 0; i < 5; i++) {
            score = sc.nextInt();
            if (score < 40) {
                score = 40;
            }
            sum += score;
        }
        System.out.println(sum / 5);
    }
}
