//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class ListNode {
//    int data;
//    ListNode link;
//
//    ListNode() {
//        this.data = 0;
//        this.link = null;
//    }
//
//    ListNode(int num) {
//        this.data = num;
//
//    }
//
//    ListNode(int num, ListNode link) {
//        this.data = num;
//        this.link = link;
//    }
//
//    public int getData() {
//        return this.data;
//    }
//}
//
//class LinkedList {
//
//    private ListNode head;
//
//    public LinkedList() {
//        head = null;
//
//    }
//
//    public void insertMiddleNode(ListNode pre, int num) {
//        ListNode newNode = new ListNode(num);
//        newNode.link = pre.link;
//        pre.link = newNode;
//    }
//
//    public void insertLastNode(int num) {
//        ListNode newNode = new ListNode(num);
//        if (head == null) {
//            this.head = newNode;
//
//        } else {
//            ListNode temp = head;
//            while (temp.link != null) {
//                temp = temp.link;
//            }
//            temp.link = newNode;
//        }
//    }
//
//    public void deleteLastNode() {
//        ListNode pre, temp;
//        if (head == null) {
//            return;
//        }
//        if (head.link == null) {
//            head = null;
//        } else {
//            pre = head;
//            temp = head.link;
//            while (temp.link != null) {
//                pre = temp;
//                temp = temp.link;
//            }
//            pre.link = null;
//
//        }
//    }
//
//    public ListNode searchNode(int num) {
//        ListNode temp = this.head;
//        while (temp != null) {
//            if (num == temp.getData()) {
//                return temp;
//            } else {
//                temp = temp.link;
//            }
//        }
//        return temp;
//    }
//
//
//}
//
//class Stack {
//
//    ListNode top;
//
//    //Boolean isFull(){
////
////    return
////}
//    Boolean isEmpty() {
//        return (top == null);
//    }
//
//    public void push(int num) {
//        ListNode newNode = new ListNode();
//        newNode.data = num;
//        newNode.link = top;
//        top = newNode;
//
//    }
//
//    public int pop() {
//        if (isEmpty()) {
//            return 0;
//        } else {
//            int num = top.data;
//            top = top.link;
//            return num;
//        }
//    }
//
//    public int peek() {
//        if (isEmpty()) {
//            return 0;
//        } else {
//            return top.data;
//        }
//    }
//
//}
//
//public class Test {
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        while (st.hasMoreTokens()) {
//            System.out.println(st.nextToken());
//        }
//    }
//}
//
