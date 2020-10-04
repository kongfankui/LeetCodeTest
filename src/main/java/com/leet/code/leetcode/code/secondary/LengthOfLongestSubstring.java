package com.leet.code.leetcode.code.secondary;

import com.leet.code.leetcode.annoations.NoPass;
import com.leet.code.leetcode.annoations.Pass;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {
    @Pass
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    @NoPass
    public int lengthOfLongestSubstring2(String s) { //"abcabcbb"
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0, r = 1, length = chars.length;
        set.add(chars[l]);
        int max = 1;
        for (; r < length; r++) {
            if (set.contains(chars[r])) {
                max = Math.max(max, r - l - 1);
                set.remove(chars[l]);
                set.add(chars[r]);
                l++;
            } else {
                set.add(chars[r]);
            }
        }
        return Math.max(max, set.size());
    }
}
