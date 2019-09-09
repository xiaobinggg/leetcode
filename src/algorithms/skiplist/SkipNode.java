package algorithms.skiplist;

public class SkipNode<E> {
	public SkipNode<E>[] forwards;
	public E data;
	public int hashcode = Integer.MIN_VALUE;
	public int nodeLevel;

	public SkipNode(E data, int node_level, int max_levels) {
		this.data = data;
		this.nodeLevel = node_level;
		this.forwards = new SkipNode[max_levels];
		if (data != null) {
			this.hashcode = data.hashCode();
		}
	}

}
