package algorithms.skiplist;

public class SkipNode<E> {
    /**
     * 指针集合，存储节点在跳表各层级中的后置节点
     */
    public SkipNode<E>[] forwards;
	/**节点数据*/
	public E data;
    /**节点hash值，用于跳表排序*/
    public int hashcode = Integer.MIN_VALUE;
    /**节点在跳表中的最大层级*/
    public int nodeLevel;

    /**
     *
     * @param data 节点数据
     * @param node_level 节点在跳表中的最大层级
     * @param max_levels 整个跳表的最大层级
     */
    public SkipNode(E data, int node_level, int max_levels) {
        this.data = data;
        this.nodeLevel = node_level;
        this.forwards = new SkipNode[max_levels];
        if (data != null) {
            this.hashcode = data.hashCode();
        }
    }

}
