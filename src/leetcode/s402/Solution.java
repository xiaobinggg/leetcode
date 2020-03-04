package leetcode.s402;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 *
 * https://leetcode-cn.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (26.99%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    8.6K
 * Total Submissions: 32K
 * Testcase Example:  '"1432219"\n3'
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 
 * 注意:
 * 
 * 
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 
 * 
 * 示例 1 :
 * 
 * 
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 
 * 
 * 示例 3 :
 * 
 * 
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * 
 * 
 */

// @lc code=start
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("112", 1));

    }

    public String removeKdigits(String num, int k) {
        if (null == num || num.length() == k) {
            return "0";
        }
        String num_cp = num;
        int removednum = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < num.length() && removednum < k; i++) {
            char cr = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > cr && removednum < k) {
                char crinstack = stack.pop();
                num_cp = num_cp.replaceFirst(Character.toString(crinstack), "");
                removednum += 1;
            }
            stack.push(cr);
        }
        while (removednum < k) {
            num_cp = num_cp.substring(0, num_cp.length() - 1);
            removednum += 1;
        }
        while (num_cp.startsWith("0")) {
            num_cp = num_cp.substring(1);
        }

        return num_cp.length() == 0 ? "0" : num_cp;
    }
}
// @lc code=end
