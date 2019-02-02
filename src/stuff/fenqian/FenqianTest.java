package stuff.fenqian;

import java.util.ArrayList;
import java.util.List;

public class FenqianTest {
	public static int[] types = { 1, 2, 5, 10 };

	public static void fenqian(int total, ArrayList<Integer> result) {
		for (int i = 0; i < types.length; i++) {
			ArrayList<Integer> oneresult = (ArrayList<Integer>) result.clone();
			int remain = total - types[i];
			if (remain == 0) {
				oneresult.add(types[i]);
				System.out.println(oneresult);
			} else if (remain > 0) {
				oneresult.add(types[i]);
				FenqianTest.fenqian(remain, oneresult);
			}
		}
	}

	public static void main(String[] args) {
		FenqianTest.fenqian(10, new ArrayList<Integer>());

	}

}
