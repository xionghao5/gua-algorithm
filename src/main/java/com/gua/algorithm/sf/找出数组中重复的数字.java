package com.gua.algorithm.sf;

import java.util.HashMap;
import java.util.Map;

public class 找出数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }
}
