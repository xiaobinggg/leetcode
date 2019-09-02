package algorithms.base;


public class BingLinkedList<E> {
	private LinkNode<E> root = null;
	private LinkNode<E> last = null;
	private int size = 0;

	public BingLinkedList() {
		root = new LinkNode(null, null, null);
		last = new LinkNode(null, root, null);
		root.next = last;
	}

	public void add(E e) {
		LinkNode<E> node = new LinkNode<E>(e, last.prev, last);
		last.prev.next = node;
		last.prev = node;
		size += 1;
	}
	public void add(E[] eArr) {
		for(E e: eArr) {
			this.add(e);
		}
	}
	public void addBefore(int index, E element) {
		LinkNode prenode = node(index);
		LinkNode<E> node = new LinkNode<E>(element, prenode.prev, prenode);
		prenode.prev.next = node;
		prenode.prev = node;
		size += 1;
	}
	public void addBeforeNode(LinkNode node, E element){

	}
	
	private LinkNode<E> node(int idx) {
		if (idx < (this.size >> 1)) {
			LinkNode<E> x = root.next;
			for(int i=0;i<idx;i++) {
				x = x.next;
			}
			return x;
		} else {
			LinkNode<E> x = last.prev;
			for(int i=this.size-1;i>idx;i--) {
				x = x.prev;
			}
		}
		return null;
	}

	public void remove(int idx) {
		LinkNode<E> node = this.node(idx);
		if (node != null) {
			node.prev.next = node.next;
			size -= 1;
		}
	}
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}


	public E get(int idx) {
		LinkNode<E> node = this.node(idx);
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
		LinkNode loopNode = root.next;
		StringBuffer buff = new StringBuffer("");
		while(loopNode != last) {
			buff.append(loopNode.e.toString()).append("--> ");
			loopNode = loopNode.next;
		}
		return buff.toString();
	}

}