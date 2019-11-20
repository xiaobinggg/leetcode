package leetcode.s33;

public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		nums = new int[] { 8,9,2,3,4 };
		Solution s33 = new Solution();
		// System.out.println(s33.search(nums, 0));
		System.out.println(s33.search(nums, 9));
	}

	public int search(int[] nums, int target) {
		if (nums.length <= 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int rotatepos = this.findRotatePos(nums, 0, nums.length - 1);
		if (nums[rotatepos] == target) {
			return rotatepos;
		} else if (rotatepos == 0) {
			return this.binarySearch(nums, target, 0, nums.length - 1);
		} else if (nums[0] > target) {
			return this.binarySearch(nums, target, rotatepos, nums.length - 1);
		} else {
			return this.binarySearch(nums, target, 0, rotatepos - 1);
		}
	}

	/**
	 * 查找旋转点下标
	 * 
	 * @param nums
	 * @return
	 */
	public int findRotatePos(int[] nums, int left, int right) {
		if (nums[left] < nums[right]) {
			return 0;
		}
		while (left <= right) {
			int pivot = left + ((right - left) / 2);
			if (nums[pivot] > nums[pivot + 1]) {
				return pivot + 1;
			} else {
				if (nums[pivot] < nums[left]) {
					right = pivot - 1;
				} else {
					left = pivot + 1;
				}
			}
		}
		return 0;
	}

	/**
	 * 二分查找
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
