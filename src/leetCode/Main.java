//package leetCode;
//
//class Node {
//
//    int data;
//    Node node;
//
//}
//
//class MinStack {
//
//    /**
//     * initialize your data structure here.
//     */
//    Node top;
//
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        Node newNode = new Node();
//        newNode.data = x;
//        if (!isEmpty()) {
//            newNode.node = top;
//            top = newNode;
//
//        } else {
//            //비어있다면
//            top = newNode;
//        }
//    }
//
//    public void pop() {
//        if (!isEmpty()) {
//            top = top.node;
//        }
//    }
//
//    public int top() {
//        return top.data;
//    }
//
//    public int getMin() {
//        if (!isEmpty()) {
//            Node searchNode = top;
//            int minNum = top.data;
//            while (searchNode != null) {
//
//                if (searchNode.data < minNum) {
//                    minNum = searchNode.data;
//                }
//                searchNode = searchNode.node;
//            }
//
//            return minNum;
//        }
//        return 0;
//    }
//
//    public boolean isEmpty() {
//        return top == null;
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(x);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */
//
//class LeetCodeStack {
//
//
//    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());  // --> Returns -3.
//        minStack.pop();
//        System.out.println(minStack.top());      //--> Returns 0.
//        System.out.println(minStack.getMin());   //--> Returns -2.
//    }
//
//
//}