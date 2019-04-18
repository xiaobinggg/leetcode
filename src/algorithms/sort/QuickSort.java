package algorithms.sort;

public class QuickSort {
	public static void main(String[] args) {

	}

	public static int[] quickSort(int[] numbers) {
		quickSortCC(numbers, 0, numbers.length - 1);
		return numbers;
	}

	public static void quickSortCC(int[] numbers, int start, int end) {
		if (start >= end) {
			return;
		}
		int p = partion(numbers, start, end);
		quickSortCC(numbers, start, p - 1);
		quickSortCC(numbers, p + 1, end);

	}

	public static int partion(int[] numbers, int start, int end) {
		int pivot = numbers[end];
		int partionPos = start;
		int swap;
		for (int i = start; i < end; i++) {
			if (numbers[i] < pivot) {
				swap = numbers[i];
				numbers[i] = numbers[partionPos];
				numbers[partionPos] = swap;
				partionPos += 1;
			}
		}
		swap = numbers[partionPos];
		numbers[partionPos] = pivot;
		numbers[end] = swap;
		return partionPos;
	}
}
