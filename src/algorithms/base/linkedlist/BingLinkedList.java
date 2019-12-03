package algorithms.base.linkedlist;


public class BingLinkedList<E> {
    public LinkNode<E> root = null;
    public LinkNode<E> last = null;
    private int size = 0;

    public BingLinkedList() {
        root = new LinkNode(null, null, null);
        last = new LinkNode(null, root, null);
        root.next = last;
    }

    public LinkNode<E> add(E e) {
        LinkNode<E> node = new LinkNode<E>(e, last.prev, last);
        last.prev.next = node;
        last.prev = node;
        size += 1;
        return node;
    }

    public void add(E[] eArr) {
        for (E e : eArr) {
            this.add(e);
        }
    }

    public LinkNode addBefore(int index, E element) {
        LinkNode prenode = node(index);
        return this.addBeforeNode(prenode, element);
    }

    public LinkNode addBeforeNode(LinkNode prenode, E element) {
        LinkNode<E> node = new LinkNode<E>(element, prenode.prev, prenode);
        prenode.prev.next = node;
        prenode.prev = node;
        size += 1;
        return node;
    }

    /**
     * 返回链表中指定下标的节点
     *
     * @param idx 下标
     * @return
     */
	public LinkNode<E> node(int idx) {
        LinkNode<E> x = null;
        if (idx < (this.size >> 1)) {
            x = root.next;
            for (int i = 0; i < idx; i++) {
                x = x.next;
            }
            return x;
        } else {
            x = last.prev;
            for (int i = this.size - 1; i > idx; i--) {
                x = x.prev;
            }
        }
        return x;
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

    /**
     * 链表反转
     */
    public void reverse() {
        LinkNode<E> prevNode = this.root;
        LinkNode<E> loopNode = this.root.next;
        while (null != loopNode.next) {
            LinkNode<E> nextNode = loopNode.next;
            loopNode.next = prevNode;
            prevNode.prev = loopNode;
            prevNode = loopNode;
            loopNode = nextNode;
        }
        loopNode.next = prevNode;
        prevNode.prev = loopNode;
        loopNode.prev = null;
        this.root.next = null;
        LinkNode<E> swap = this.root;
        this.root = this.last;
        this.last = swap;
    }

    /**
     * 检测链表是否有环
     *
     * @return
     */
    public boolean checkCircle() {
        LinkNode<E> slowPointer = this.root;
        LinkNode<E> fasterPointer = this.root;
        while (null != fasterPointer && null != fasterPointer.next) {
            slowPointer = slowPointer.next;
            fasterPointer = fasterPointer.next.next;
            if (slowPointer == fasterPointer) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回链表中间节点
     *
     * @return
     */
    public LinkNode<E> getMidNode() {
        int mid = this.size / 2;
        return this.node(mid);
    }

    public String toString() {
        LinkNode loopNode = root.next;
        StringBuffer buff = new StringBuffer("");
        while (loopNode != last) {
            buff.append(loopNode.e.toString()).append("--> ");
            loopNode = loopNode.next;
        }
        return buff.toString();
    }

}
