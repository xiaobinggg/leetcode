package leetcode.s217;

import java.util.Arrays;
import java.util.Random;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean result = solution.containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
        if (nums == null || nums.length <= 1) {
            return false;
        }
        this.quickSortCC(nums, 0, nums.length - 1);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                return true;
            } else {
                prev = nums[i];
            }
        }
        return false;
    }

    public void quickSortCC(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int partion = this.partion(nums, start, end);
        this.quickSortCC(nums, start, partion - 1);
        this.quickSortCC(nums, partion + 1, end);
    }

    public int partion(int nums[], int start, int end) {
        int partionPos = start;
        int rand = new Random().nextInt(end - start + 1) + start;
        int pivot = nums[rand];
        int swap = nums[rand];
        nums[rand] = nums[end];
        nums[end] = swap;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap = nums[i];
                nums[i] = nums[partionPos];
                nums[partionPos] = swap;
                partionPos += 1;
            }
        }
        swap = nums[partionPos];
        nums[partionPos] = pivot;
        nums[end] = swap;
        return partionPos;
    }
}