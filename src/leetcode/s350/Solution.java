package leetcode.s350;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        Solution solution = new Solution();
        int[] result = solution.intersect(nums1, nums2);
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i] + ",");
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        this.quickSortCC(nums1, 0, nums1.length - 1);
        this.quickSortCC(nums2, 0, nums2.length - 1);
        List<Integer> resultArr = new ArrayList<Integer>();
        int pos1 = 0, pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                resultArr.add(nums1[pos1]);
                pos1 += 1;
                pos2 += 1;
            } else if (nums1[pos1] > nums2[pos2]) {
                pos2 += 1;
            } else {
                pos1 += 1;
            }
        }
        int[] result = new int[resultArr.size()];
        for (int i = 0; i < resultArr.size(); i++) {
            result[i] = resultArr.get(i);
        }
        return result;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param start
     * @param end
     */
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
