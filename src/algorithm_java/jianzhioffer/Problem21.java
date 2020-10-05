package algorithm.jianzhioffer;

import java.util.ArrayList;

public class Problem21 {

    static class Stack {
        private ArrayList<Integer> data = new ArrayList<>();
        private ArrayList<Integer> auxiliary = new ArrayList<>();

        public void push(Integer e) {
            data.add(e);
            if(auxiliary.isEmpty()) {
                auxiliary.add(e);
            } else {
                if(auxiliary.get(auxiliary.size() - 1) < e) {
                    auxiliary.add(auxiliary.get(auxiliary.size() - 1));
                } else {
                    auxiliary.add(e);
                }
            }
        }

        public Integer pop() {
            auxiliary.remove(auxiliary.size() - 1);
            Integer rst = data.get(data.size() - 1);
            data.remove(data.size() - 1);
            return rst;
        }

        public Integer min() {
            return auxiliary.get(auxiliary.size() - 1);
        }

    }

    public static void main(String[] args) {
        Problem21.Stack stack = new Problem21.Stack();
        int[] data = new int[]{21, 96, 33, 5, 9, 54, 3};
        for(int e : data) {
            stack.push(e);
        }
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
