package algorithms.sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SimpleSort {
	public static int NSIZE = 100000;

	public static void main(String[] args) {
		int[] numbers = new int[NSIZE];
		Random rand = new Random();
		for (int m = 0; m < NSIZE; m++) {
			numbers[m] = rand.nextInt(NSIZE);
		}
		int[] instNumbers = Arrays.copyOf(numbers,numbers.length);
		Long starttime = new Date().getTime();
		bubbleSort(numbers);
		Long endtime = new Date().getTime();
		System.out.println("bubbleSort cost: " + Long.toString(endtime - starttime));
		
		starttime = new Date().getTime();
		insertSort(numbers);
		endtime = new Date().getTime();
		System.out.println("insertSort cost: " + Long.toString(endtime - starttime));
//		for (int i = 0; i < nunmbers.length; i++) {
//			System.out.print(Integer.toString(nunmbers[i]) + ',');
//		}
	}

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

	public static void insertSort(int[] numbers) {
		int sorted_numbers = 1;
		int swap;
		for (int i = 1; i < numbers.length; i++) {
			// for (int j = 0; j < sorted_numbers; j++) {
			// if (numbers[i] < numbers[j]) {
			// swap = numbers[i];
			// for (int m = sorted_numbers; m > j; m--) {
			// numbers[m] = numbers[m - 1];
			// }
			// numbers[j] = swap;
			// break;
			// }
			// }
			// sorted_numbers += 1;

			int j = i - 1;
			swap = numbers[i];
			while (j >= 0 && numbers[j] > swap) {
				numbers[j + 1] = numbers[j];
				j -= 1;
			}
			if (j != (i - 1)) {
				numbers[j + 1] = swap;
			}
		}
	}
}
