package leetcode.s189;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int numsSize = nums.length;
        int rotateNum = k % numsSize;
        int swap = Integer.MIN_VALUE;
        while (rotateNum > 0) {
            swap = nums[numsSize - 1];
            for (int i = numsSize - 1; i > 0; i -= 1) {
                nums[i] = nums[i - 1];
            }
            nums[0] = swap;
            rotateNum -= 1;
        }
    }

    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int numsSize = nums.length;
        k = k % numsSize;
        if (k <= 0) {
            return;
        }
        int swapedNum = 0;
        for (int start = 0; swapedNum < numsSize; start += 1) {
            int current = start;
            int currentVal = nums[start];
            do {
                int next = (current + k) % numsSize;
                int temp = nums[next];
                nums[next] = currentVal;
                currentVal = temp;
                swapedNum += 1;
                current = next;
            } while (current != start);
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54};
        test.rotate1(nums, 45);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
