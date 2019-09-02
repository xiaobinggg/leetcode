package algorithms.skiplist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import algorithms.base.BingLinkedList;
import algorithms.base.LinkNode;
import sun.awt.image.ImageWatched;

/**
 * @Description:
 * @author:LiuXiaoBing
 * @date: 2019年8月29日 下午4:51:12
 */
public class BingSkipList<E> implements ISkipList<E>{
    private Object o;
    private LinkedList justforJump;
	private BingLinkedList<E> linkedList = new BingLinkedList<E>();
	private static final int MAX_LEVELS = 5;
	private static final Double RANDOMVAL = 0.5;
	private BingLinkedList<SkipNode>[] skipLists = new BingLinkedList[MAX_LEVELS];


	@Override
	public boolean zadd(E o) {
		// 维护底层链表结构
		LinkNode lnode = this.findFirstGreater(o);
		if(lnode.next == null) {
			this.linkedList.add(o);
		}
		// 完善跳表各层次信息
		return false;
	}

	@Override
	public boolean zrem(E o) {
		return false;
	}

	@Override
	public int zrank(E o) {
		return 0;
	}

	@Override
	public List zrangebyscore(E min, E max) {
		return null;
	}

	/**
	 * 查找第一个大于指定元素的节点
	 * @param o
	 * @return
	 */
	private LinkNode findFirstGreater(E o) {
		// assert all skipList's last element 's hashcode is INTEGER.MAX_VALUE
		int hashcode = o.hashCode();
		BingLinkedList<SkipNode> skipList = skipLists[MAX_LEVELS-1];
	    SkipNode skipNode = skipList.get(0);
	    int level = 0 ;
	    while(level != MAX_LEVELS) {
	    	if (skipNode.hashcode == hashcode) {
	    	    return skipNode.linkNode;
			} else if(skipNode.hashcode < hashcode) {
	    		skipNode = skipNode.next;
			} else {
	    		skipNode = skipNode.prev.down;
	    		level += 1;
			}
		}
		LinkNode linkNode = skipNode.linkNode;
	    while(linkNode.next != null && linkNode.e.hashCode() != hashcode) {
	    	linkNode = linkNode.next;
		}
		return linkNode;
	}

	private class SkipNode{
		private LinkNode linkNode;
		private int hashcode;
		private SkipNode next;
		private SkipNode prev;
		private SkipNode down;
	}
}
