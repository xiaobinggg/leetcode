package algorithms.base;

public class BingLinkedListTest {
	public static void main(String[] args) {
		BingLinkedList<String> list = new BingLinkedList<String>();
		list.add(new String[] {"a","b","c","d","e"});
		System.out.println(list.size());
		list.remove(1);
		System.out.println(list.toString());
	}

}
