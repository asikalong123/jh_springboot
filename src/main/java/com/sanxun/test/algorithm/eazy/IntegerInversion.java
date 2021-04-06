package com.sanxun.test.algorithm.eazy;

public class IntegerInversion {
    /**
     * 整数反转
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 输入：x = 123
     * 输出：321
     * 输入：x = -123
     * 输出：-321
     * 输入：x = 120
     * 输出：21
     * 输入：x = 0
     * 输出：0
     **/

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse2(111111119);
        System.out.println(reverse);
    }


    static class Solution {
        /**
         *这边我第一反应是一个很憨批的解法
         * 转字符串然后字符倒序然后转回来
         */
        public int reverse(int x) {
            boolean a = false;
            Integer b = x;
            String s = b.toString();
            if (x < 0) {
                a = true;
                s = -x + "";
            }
            char[] chars = s.toCharArray();
            char[] c = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                c[i] = chars[chars.length - 1 - i];
            }
            StringBuilder sb = new StringBuilder();
            for (char c1 : c) {
                sb.append(c1);
            }
            if (Long.valueOf(sb.toString())>Math.pow(2,32)-1){
                return 0;
            }
            Integer i = Integer.valueOf(sb.toString());
            if (a) {
                return -i;
            }
            return i;
        }


        public int reverse2(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }
}
