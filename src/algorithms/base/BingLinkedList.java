package algorithms.base;

public class BingLinkedList<E> {
	private Node<E> root = null;
	private Node<E> last = null;
	private int size = 0;

	public BingLinkedList() {
		root = new Node(null, null, null);
		last = new Node(null, root, null);
		root.next = last;
	}

	public void add(E e) {
		Node<E> node = new Node<E>(e, last.prev, last);
		last.prev.next = node;
		last.prev = node;
		size += 1;
	}
	public void add(E[] eArr) {
		for(E e: eArr) {
			this.add(e);
		}
	}

	public void remove(int idx) {
		Node<E> node = this.getNode(idx);
		if (node != null) {
			node.prev.next = node.next;
			size -= 1;
		}
	}

	private Node<E> getNode(int idx) {
		if (idx < 0 || idx >= size) {
			return null;
		}
		int loop = idx;
		Node<E> tempNode = root.next;
		while (loop > 0) {
			tempNode = tempNode.next;
			loop -= 1;
		}
		return tempNode;
	}

	public E get(int idx) {
		Node<E> node = this.getNode(idx);
		if (node != null) {
			return node.e;
		} else {
			return null;
		}

	}

	public int size() {
		return this.size;
	}
	
	public String toString() {
		Node loopNode = root.next;
		StringBuffer buff = new StringBuffer("");
		while(loopNode != last) {
			buff.append(loopNode.e.toString()).append("--> ");
			loopNode = loopNode.next;
		}
		return buff.toString();
	}

	private static class Node<E> {
		E e;
		Node<E> prev;
		Node<E> next;

		Node(E e, Node<E> prev, Node<E> next) {
			this.e = e;
			this.prev = prev;
			this.next = next;
		}
	}
}
