package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 桶排序算法 适合数据在一定范围内均匀分布的场景,如订单按金额排序、用户按年龄排序等
 * 构造若然个桶，将数据分散到不同的桶中，再分别对每个桶中的元素进行快速排序
 * @author LiuXiaoBing
 *
 */
public class BucketSort {
	public static void main(String[] args) {
		int[] numbers = new int[] { 22, 5, 11, 41, 45, 26, 29, 10, 7, 8, 30, 27, 42, 43, 40 };
		
		//构造5个桶
		Object[] buckets = new Object[5];
		for (int i = 0; i < 5; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		//将元素按大小分别放到5个中
		for (int num : numbers) {
			int bucketPos = num / 10;
			List<Integer> bucket = (List<Integer>) buckets[bucketPos];
			bucket.add(num);
		}
		for (Object obucket : buckets) {
			List<Integer> bucket = (List<Integer>) obucket;
			for (int m : bucket) {
				System.out.print(m+", ");
			}
			System.out.println("");
		}
		
		//对每个桶进行快速排序
		for (int i = 0; i < buckets.length; i++) {
			List<Integer> bucket = (List<Integer>) buckets[i];
			Integer[] bucketArr = new Integer[bucket.size()];
			bucket.toArray(bucketArr);
			int[] arr = Arrays.stream(bucketArr).mapToInt(Integer::valueOf).toArray();
			arr = QuickSort.quickSort(arr);
			buckets[i] =IntStream.of(arr).boxed().collect(Collectors.toList());
		}
		
		// 合并5个桶中的数据
		for (Object obucket : buckets) {
			List<Integer> bucket = (List<Integer>) obucket;
			for (int m : bucket) {
				System.out.print(m+", ");
			}
		}

	}
}
