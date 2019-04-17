package algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序算法实现
 * 
 * @author LiuXiaoBing
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] numbers = { 7, 6, 2, 4, 1, 9, 3, 8, 0, 5 };
		int[] sortedNumbers = mergeSort(numbers);
		for (int num : sortedNumbers) {
			System.out.print(Integer.toString(num) + ',');
		}
	}

	/**
	 * 归并排序
	 * @param numbers 待排序数组
	 * @return 排序好的数组
	 */
	public static int[] mergeSort(int[] numbers) {
		if (numbers.length == 1) {
			return numbers;
		} else {
			//将数组分为两份
			int mid = numbers.length / 2;
			int[] left_arr = Arrays.copyOfRange(numbers, 0, mid);
			int[] right_arr = Arrays.copyOfRange(numbers, mid, numbers.length);
			//对两份分别进行归并排序
			left_arr = mergeSort(left_arr);
			right_arr = mergeSort(right_arr);
			//合并排好序的两个数组
			return merge(left_arr, right_arr);
		}
	}

	/**
	 * 合并排好序的两个数组
	 * @param left_arr
	 * @param right_arr
	 * @return
	 */
	public static int[] merge(int[] left_arr, int[] right_arr) {
		int[] result = new int[left_arr.length + right_arr.length];
		int left_idx = 0;
		int right_idx = 0;
		int idx = 0;
		while (left_idx < left_arr.length && right_idx < right_arr.length) {
			if (left_arr[left_idx] > right_arr[right_idx]) {
				result[idx] = right_arr[right_idx];
				right_idx += 1;
			} else {
				result[idx] = left_arr[left_idx];
				left_idx += 1;
			}
			idx += 1;
		}
		if (left_idx < left_arr.length) {
			for (int i = left_idx; i < left_arr.length; i++) {
				result[idx] = left_arr[i];
				idx += 1;
			}
		} else {
			for (int i = right_idx; i < right_arr.length; i++) {
				result[idx] = right_arr[i];
				idx += 1;
			}
		}
		return result;
	}

}
