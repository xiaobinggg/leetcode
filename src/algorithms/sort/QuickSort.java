package algorithms.sort;

/**
 * 快速排序算法实现 O(nlogn)
 * 要排序下标为p..n的数组，选取其中任意一个元素作为pivot(分区点)
 * 将数组分为左右两部分，所有<pivot的元素放到左边，>pivot的元素放到右边 递归上述步骤直到区间长度为0
 * 
 * @author LiuXiaoBing
 *
 */
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

	/**
	 * 分区函数
	 * 1、分区点元素pivot取数组最后一个值，设置一个下标变量pos存储分区位置
	 * 遍历数组，如果元素小于分区点pivot，将其挪到pos左边(具体操作是将a[pos]与a[i]元素互换，然后pos+1)
	 * 重点是对pos处理方式的理解。pos位置默认是0，它每往前走一步，代表有一个<pivot的元素被置换过来了。
	 * @param numbers 带分区数组
	 * @param start 开始下标
	 * @param end 结束下标
	 * @return
	 */
	public static int partion(int[] numbers, int start, int end) {
		int pivot = numbers[end]; // 分区点元素
		int partionPos = start; // 分区下标，partionPos左边的元素<pivot,右边的元素>pivot
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
