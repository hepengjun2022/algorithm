package com.leecode.array;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author hepengjun
 * @description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @updateTime 2022/4/22 0022 19:35
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int[] ints = getInts();
        System.out.println(ints[0] + "," + ints[1]);
    }
    static int[] getInts() {
        int nums[] = {-10, -1, -18, -19};//-19,-18,-10,-1
        int target = -19;
        int results[] = new int[2];
        //将数字放入map容器
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int target_num = target - nums[i];
            if (map.containsKey(target_num)) {
                int order = map.get(target_num);
                if (order != i) {
                    if (i > order) {
                        results[0] = order;
                        results[1] = i;
                    } else {
                        results[0] = i;
                        results[1] = order;
                    }
                    return results;
                }
            }
        }
        throw new RuntimeException("未找到符合目标的两数之和");
    }
}
