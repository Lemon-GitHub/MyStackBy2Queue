package MyStackBy2Queue;

import java.util.LinkedList;

public class test {
    //用队列实现栈
    /** Initialize your data structure here. */
    private LinkedList<Integer> A = new LinkedList<>();
    private LinkedList<Integer> B = new LinkedList<>();
    //A始终是用来入栈的 B始终是空的

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //空栈的情况，直接返回
        //把A中的元素导入B中 当A中只剩一个元素时即可出栈
        //交换A和B 使A始终用来入栈 B为空
        if(A.isEmpty()) {
            return 0;
        }
        while(A.size() > 1){
            int cur = A.removeFirst();
            B.addLast(cur);
        }

        int ret = A.removeFirst();
        swapAB();
        return ret;

    }

    private void swapAB() {
        LinkedList<Integer>tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public int top() {
        //空栈的情况，直接返回
        //把A中的元素导入B中 当A中只剩一个元素时即可保存栈顶元素
        //交换A和B 使A始终用来入栈 B为空
        if(A.isEmpty()) {
            return 0;
        }
        while(A.size() > 1){
            int cur = A.removeFirst();
            B.addLast(cur);
        }

        int ret = A.removeFirst();
        B.addLast(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }
}
