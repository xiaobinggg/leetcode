package algorithms.base;

public class LinkNode<E> {
    public E e;
    public LinkNode<E> prev;
    public LinkNode<E> next;

    LinkNode(E e, LinkNode<E> prev, LinkNode<E> next) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }
}
