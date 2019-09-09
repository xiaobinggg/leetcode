package algorithms.base;

public class BingLinkedListTest {
	public static void main(String[] args) {
		BingLinkedList<String> list = new BingLinkedList<String>();
		list.add(new String[] {"a","b","c","d","e"});
		System.out.println(list.toString());
//		list.remove(1);
		LinkNode node = list.addBefore(1, "f");
		list.addBeforeNode(node, "g");
		System.out.println(list.toString());
	}

}
