package leetcode.s283;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,2,0,3};
        Solution solution = new Solution();
        solution.moveZeroes(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int zeroNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums += 1;
            } else {
                nums[i - zeroNums] = nums[i];
            }
        }
        for (int i = 1; i <= zeroNums; i++) {
            nums[nums.length - i] = 0;
        }
    }
}
