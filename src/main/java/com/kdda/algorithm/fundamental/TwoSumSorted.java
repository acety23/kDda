package com.kdda.algorithm.fundamental;

import java.util.HashMap;
import java.util.Map;

/* Given an array of integers nums(sorted) and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * tag 双指针 two pointers
 */
public class TwoSumSorted {

    public static int[] towSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l != r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{l, r};
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }


    public static int[] twoSumNotSorted(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] resultSorted = towSum(nums, target);
        int[] resultNotSorted = twoSumNotSorted(nums, target);
        if (resultSorted != null) {
            System.out.println("[" + resultSorted[0] + ", " + resultSorted[1] + "]");
        }
        System.out.println("sorted no answer");
        if (resultNotSorted != null) {
            System.out.println("[" + resultNotSorted[0] + ", " + resultNotSorted[1] + "]");
            System.out.println("notSorted no answer");
        }
    }


}
