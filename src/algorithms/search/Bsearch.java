/**
 * 
 */
package algorithms.search;

/**
 * @Description: 二分查找
 *               1、查找第一个值等于给定值的元素 findFirst
 *               2、查找最后一个值等于给定值的元素
 *               3、查找第一个大于等于给定值的元素
 *               4、查找最后一个小于等于给定值的元素
 * @author:LiuXiaoBing
 * @date: 2019年8月1日 下午8:25:20
 */
public class Bsearch {
	
	/**
	 * 查找第一个值等于给定值的元素
	 */
	public static int findFirst(int[] arr, int val) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] < val) {
				low = mid + 1;
			} else if (arr[mid] > val) {
				high = mid - 1;
			} else {
				if (mid == 0 || arr[mid - 1] < val) {
					return mid;
				} else {
					high = mid - 1;
				}

			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个值等于给定值的元素
	 */
	public static int findlast(int[] arr, int val) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] < val) {
				low = mid + 1;
			} else if (arr[mid] > val) {
				high = mid - 1;
			} else {
				if (mid == arr.length-1 || arr[mid + 1] > val) {
					return mid;
				} else {
					low = mid + 1;
				}

			}
		}
		return -1;
	}
	
	/**
	 * 查找第一个大于等于给定值的元素
	 */
	public static int findFirstNotLess(int[] arr, int val) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] < val) {
				low = mid + 1;
			} else if (arr[mid] >= val) {
				if (mid == 0 || arr[mid-1] < val) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个小于等于给定值的元素
	 * @param args
	 */
	public static int findLastNotLarge(int[] arr, int val) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] <= val) {
				if(mid==arr.length-1 || arr[mid+1]>val) {
					return mid;
				}else {
					low = mid + 1;
				}
			} else if (arr[mid] > val) {
				high = mid - 1;
			} 
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 4, 5, 6, 8, 8, 8, 11, 18 };
		System.out.println(findFirst(arr,8));
		System.out.println(findlast(arr,8));
		System.out.println(findFirstNotLess(arr,8));
		System.out.println(findLastNotLarge(arr,8));

	}

}
