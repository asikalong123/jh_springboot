package com.sanxun.test.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbers {
    /**
     * 两数之和
     * <p>
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum2(nums, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            /**
             * 第一反应肯定是遍历数组 每次取一个数然后看看列表中有没有剩余的那个数
             * 然鹅
             * 执行用时：0 ms在所有 Java 提交中击败了100.00%的用户
             * 内存消耗：38.8 MB在所有 Java 提交中击败了9.35%的用户
             * 时间复杂度n^2 空间 o(1)
             */
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        public int[] twoSum2(int[] nums, int target) {
            /**
             *算法2 hash表 可减少时间复杂度
             * 时间复杂度n 空间 o(n)
             */
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target-nums[i])){
                    return new int[]{map.get(target-nums[i]),i};
                }else {
                    map.put(nums[i],i );
                }
            }
            return null;
        }
    }
    /**
     * 小结：本题只想到暴力解法 明显时间复杂度过高 后来想到用二分法 但是给定数组是无序的 所以二分法也不适合
     * 最后看题解最好的解法是采用hash表存储 以空间换时间
     * 但是在数据量极大的情况下hash可能不如遍历效率高
     */

}
