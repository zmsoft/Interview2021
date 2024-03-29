package com.quest.Interview.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther zmsoft
 * @Created 2021/3/16 10:24
 *  给定一个整数数组nums 和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
 *  你可以假设每种输入只会对应一个答案。但是，数组中间同一个元素不能使用两遍。
 *  示例：
 *  给定 nums = [2,7,11,15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0,1]
 */
public class Demo2 {
    public static void main(String[] args){

        int[] numArray = new int[]{2,7,11,15};
        for (int num:
             twoSum(numArray,17)) {
            System.out.println(num);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
