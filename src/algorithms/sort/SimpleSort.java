package algorithms.sort;

/**
 *    ,.   ,.
   \.\ /,/
    L X B
    |. .|
   ("_, l
    ,- , \
   (_)(_) Y,.
    _j _j |,'  LiuXiaoBing
   (_,(__,'

 */
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SimpleSort {
	public static int NSIZE = 100000;

	public static void main(String[] args) {
		int[] numbers = new int[NSIZE];
		// int[] numbers = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Random rand = new Random();
		for (int m = 0; m < NSIZE; m++) {
			numbers[m] = rand.nextInt(NSIZE);
		}
		// System.out.println("");
		Long starttime, endtime;

		/*
		 * starttime = new Date().getTime(); int[] bubbleNumbers =
		 * Arrays.copyOf(numbers, numbers.length); bubbleSort(bubbleNumbers);
		 * endtime = new Date().getTime();
		 * System.out.println("bubbleSort cost: " + Long.toString(endtime -
		 * starttime));
		 */

		starttime = new Date().getTime();
		int[] insertNumbers = Arrays.copyOf(numbers, numbers.length);
		insertSort(insertNumbers);
		endtime = new Date().getTime();
		System.out.println("insertSort cost: " + Long.toString(endtime - starttime));

		starttime = new Date().getTime();
		int[] shellNumbers = Arrays.copyOf(numbers, numbers.length);
		shellSort(shellNumbers);
		endtime = new Date().getTime();
		System.out.println("shellSort cost: " + Long.toString(endtime - starttime));
		// for (int i = 0; i < numbers.length; i++) {
		// System.out.print(Integer.toString(numbers[i]) + ',');
		// }
		for (int i = 0; i < insertNumbers.length; i++) {
			if (insertNumbers[i] != shellNumbers[i]) {
				System.out.println("error");
				break;
			}
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param numbers
	 *            待排序数组
	 */
	public static void bubbleSort(int[] numbers) {
		int swap;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swap = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = swap;
				}
			}
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param numbers
	 *            待排序数组
	 */
	public static void insertSort(int[] numbers) {
		int swap;
		for (int i = 1; i < numbers.length; i++) {
			int j = i - 1; // j 及之前的元素已排好序
			swap = numbers[i];
			while (j >= 0 && numbers[j] > swap) { // 排好序的数组移位，为插入元素腾出位置
				numbers[j + 1] = numbers[j];
				j -= 1;
			}
			if (j != (i - 1)) {
				numbers[j + 1] = swap;
			}
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param array
	 *            待排序数组
	 */
	public static void shellSort(int[] array) {
		int gap = array.length / 2; // 希尔增量
		int i;
		int j;
		int temp;
		while (gap >= 1) {
			for (i = gap; i < array.length; i++) {
				temp = array[i];
				j = i - gap;
				while (j >= 0 && array[j] > temp) {
					array[j + gap] = array[j];
					j =j- gap;
				}
				array[j + gap] = temp;
			}
			gap = gap / 2;
		}
	}
}
