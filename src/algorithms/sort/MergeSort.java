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
			int[] leftArr = Arrays.copyOfRange(numbers, 0, mid);
			int[] rightArr = Arrays.copyOfRange(numbers, mid, numbers.length);
			//对两份分别进行归并排序
			leftArr = mergeSort(leftArr);
			rightArr = mergeSort(rightArr);
			//合并排好序的两个数组
			return merge(leftArr, rightArr);
		}
	}

	/**
	 * 合并排好序的两个数组
	 * @param leftArr
	 * @param rightArr
	 * @return
	 */
	public static int[] merge(int[] leftArr, int[] rightArr) {
		int[] result = new int[leftArr.length + rightArr.length];
		int leftIdx = 0;
		int rightIdx = 0;
		int idx = 0;
		while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
			if (leftArr[leftIdx] > rightArr[rightIdx]) {
				result[idx++] = rightArr[rightIdx++];
			} else {
				result[idx++] = leftArr[leftIdx++];
			}
		}
		if (leftIdx < leftArr.length) {
			for (int i = leftIdx; i < leftArr.length; i++) {
				result[idx++] = leftArr[i];
			}
		} else {
			for (int i = rightIdx; i < rightArr.length; i++) {
				result[idx++] = rightArr[i];
			}
		}
		return result;
	}

}
