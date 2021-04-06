package com.sanxun.test.algorithm.eazy;

public class AddTwoNumbers {

    /**
     * 两数之和
     * <p>
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 刚开始看到这题的时候 首先思路是把链表中的数字取出来 化成多位的int类型相加 然后再转回链表
     * 但有很多问题 第一 链表顺序是反的 转成int类型还要设计改变顺序
     * 第二 链表和int直接的相互转换感觉很憨批  而且最主要的 我还不知道链表的长度 太蛋疼了
     */
    class Solution {
        /**
         * 官方写法
         * 靠 官方写法比我想象的简单多了 就是一位一位的加 然后保留进位数 最后再加一种有位数增加的情况
         * 时间 max（l1,l2）
         * 空间 max（l1,l2）
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }

        /**
         * 常规算法应该就是上面那种 可以再简化（比如头结点和尾结点相等的情况只会出现一次 可以在开始就做处理干掉if）（carry也可以用三元
         * 来做 carry = sum>9?1:0可以提高效率）
         * 看到一哥们提出了一种递归算法 挺巧妙的 占用内存反而小了
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            l2.val = l1.val + l2.val;
            if (l2.val >= 10) {
                l2.val = l2.val % 10;
                if (l2.next != null) {
                    l2.next.val = l2.next.val + 1;
                    if (l2.next.val == 10) {
                        l2.next = addTwoNumbers2(new ListNode(0, null), l2.next);
                    }
                } else {
                    l2.next = new ListNode(1, null);
                }
            }
            l2.next = addTwoNumbers2(l1.next, l2.next);
            return l2;
        }
    }
}
