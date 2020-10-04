package com.leet.code.leetcode.code;

import com.leet.code.leetcode.code.simple.TwoSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {

    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}