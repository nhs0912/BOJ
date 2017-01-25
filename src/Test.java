//import java.util.Scanner;
//
///**
// *  문제 번호 : 2504
// *  문제 이름 : 괄호의 값
// *  문제 주소 : https://www.acmicpc.net/problem/2504
// */
//class Test {
//
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int[] check = new int[str.length()];
//        int[] point = new int[str.length()];
//        char[] a = str.toCharArray();
//        int j = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (a[i] == '(' || a[i] == '[') {
//                check[j++] = (a[i] == '(' )? ')' : ']';
//            }
//            if (a[i] == ')' || a[i] == ']') {
//                --j;
//                if (j < 0 || check[j] != a[i]) {
//                    point[0] = 0;
//                    break;
//                }
//                point[j] += (check[j] == ')' ? 2 : 3) * (point[j + 1]!=0 ? point[j + 1] : 1);
//                point[j + 1] = 0;
//            }
//        }
//        System.out.println(point[0]);
//    }
//
//}
//
//
//
