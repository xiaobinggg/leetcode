/**
 * 二分查找的变形问题
 * 查找第一个值等于给定值的元素
 * 查找最后一个值等于给定值的元素
 * 查找第一个大于等于给定值的元素
 * 查找最后一个小于等于给定值的元素
 */
package algorithms.find;

/**
 * @author LiuXiaoBing 
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18 };
		System.out.format("第一个等于8的元素是:number[%s]%n", BinarySearch.findFirst(numbers, 8));
		System.out.format("最后一个等于8的元素是:number[%s]%n", BinarySearch.findLast(numbers, 8));
		System.out.format("第一个大于等于8的元素是:number[%s]%n", BinarySearch.findFirstNotLess(numbers, 8));
		System.out.format("最后一个小于等于8的元素是:number[%s]%n", BinarySearch.findLastNotGreater(numbers, 8));
	}

	/**
	 * 查找第一个值等于给定值的元素
	 * @param numbers
	 * @param val
	 * @return
	 */
	static int findFirst(int[] numbers, int val) {
		int start = 0;
		int end = numbers.length - 1;
		int mid = start + ((end-start) >>1);
		while(start < end) {
			if (numbers[mid] > val) {
				end = mid - 1;
			} else if(numbers[mid] < val) {
				start = mid + 1;
			} else {
				// 此时找到了一个相等的元素，如果该元素在数组开头，或者与它前一个元素的值不相等，就是要找的目标
				// 否则再从前半个区间中寻找
				if (mid == 0 || numbers[mid-1] != numbers[mid]) {
					return mid;
				} else {
					end = mid - 1;
				}
			}
			mid = start + ((end-start) >>1);
		}
		return -1;
	}

	/**
	 * 查找最后一个值等于给定值的元素
	 * @param numbers
	 * @param val
	 * @return
	 */
	static int findLast(int[] numbers, int val) {
		int start = 0;
		int end = numbers.length - 1;
		int mid = start + ((end-start) >>1);
		while(start < end) {
			if (numbers[mid] > val) {
				end = mid - 1;
			} else if(numbers[mid] < val) {
				start = mid + 1;
			} else {
				// 此时找到了一个相等的元素，如果该元素在数组尾部，或者与它后一个元素的值不相等，就是要找的目标
				// 否则再从后半个区间中寻找
				if (mid == numbers.length-1 || numbers[mid+1] != numbers[mid]) {
					return mid;
				} else {
					start = mid + 1;
				}
			}
			mid = start + ((end-start) >>1);
		}
		return -1;
	}

	/**
	 * 查找第一个大于等于给定值的元素
	 * @param numbers
	 * @param val
	 * @return
	 */
	static int findFirstNotLess(int[] numbers, int val) {
		int start = 0;
		int end = numbers.length - 1;
		int mid = start + ((end-start) >>1);
		while(start < end) {
			if (numbers[mid] < val) {
				start = mid + 1;
			} else {
				if (mid == 0 || numbers[mid-1] < val) {
					return mid;
				}else {
					end = mid - 1;
				}
			}
			mid = start +((end-start) >>1);
		}
		return -1;
	}
	/**
	 * 查找最后一个小于等于给定值的元素
	 * @param numbers
	 * @param val
	 * @return
	 */
	static int findLastNotGreater(int[] numbers, int val) {
		int start = 0;
		int end = numbers.length - 1;
		int mid = start + ((end-start) >>1);
		while(start < end) {
			if (numbers[mid] > val) {
				end = mid - 1;
			} else {
				if (mid == numbers.length-1 || numbers[mid+1] > val) {
					return mid;
				}else {
					start = mid + 1;
				}
			}
			mid = start +((end-start) >>1);
		}
		return -1;
	}
}



















