package leetcode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 */
public class LeetCode445 {
    public void mainEntrance() {
        int[] a = {2, 4, 3};
        int[] b = {5, 6, 4};
        ListNode l1 = initListNode(a);
        ListNode l2 = initListNode(b);
        ListNode rst = addTwoNumbers(l1, l2);
        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

    private ListNode initListNode(int[] a) {
        ListNode header = null;
        ListNode t = null;
        for (int i : a) {
            if (header == null) {
                header = new ListNode(i);
                t = header;
            } else {
                t.next = new ListNode(i);
                t = t.next;
            }

        }
        return header;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        pushStack(l1, stack1);
        pushStack(l2, stack2);
        int count = Math.max(stack1.size(), stack2.size());
        int step = 0;
        for (int i = 0; i < count; i++) {
            int num = (stack1.empty() ? 0 : stack1.pop()) + (stack2.empty() ? 0 : stack2.pop()) + step;
            stack3.push(num % 10);
            step = num / 10;
        }
        if (step != 0) {
            stack3.push(step);
        }
        Iterator<Integer> iterator = stack3.iterator();
        ListNode node = null;
        ListNode point = null;
        while (!stack3.empty()) {
            if (node == null) {
                node = new ListNode(stack3.pop());
                point = node;
            } else {
                point.next = new ListNode(stack3.pop());
                point = point.next;
            }
        }
        return node;
    }

    private void pushStack(ListNode l1, Stack<Integer> stack1) {
        ListNode t = l1;
        while (t != null) {
            stack1.push(t.val);
            t = t.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
