package algorithms.base.linkedlist;

public class BingLinkedListTest {
	public static void main(String[] args) {
		BingLinkedList<String> list = new BingLinkedList<String>();
		list.add(new String[] {"a","b","c","d","e"});
		System.out.println(list.toString());
//		list.remove(1);
//		list.reverse();
		System.out.println(list.getMidNode());

//		list.last.next = list.root;
//		System.out.println(list.checkCircle());
	}

}
