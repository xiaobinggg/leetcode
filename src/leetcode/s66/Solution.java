package leetcode.s66;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{ 9, 9};
        Solution solution = new Solution();
        int[] result = solution.plusOne(nums1);
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i] + ",");
        }
    }
    public int[] plusOne(int[] digits) {
        if (digits.length <= 0) {
            return new int[]{};
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i] = digits[i] +1;
                    break;
                } else if(digits[i] == 9) {
                    digits[i] = 0;
                }
            }
            if (digits[0] == 0) {
                int[] result = new int[digits.length+1];
                result[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    result[i+1] = digits[i];
                }
                return result;
            } else {
                return digits;
            }
        }
    }
}
