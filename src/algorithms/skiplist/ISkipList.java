package algorithms.skiplist;

import java.util.List;
/**
 * @Description: 跳表接口类,仿照redis中的sorted set
 * 插入一个数据； 删除一个数据； 查找一个数据；按照区间查找数据
 * @author:LiuXiaoBing 
 * @date: 2019年8月29日 下午5:07:29
 */
public interface ISkipList<E> {
	/**
	 * 插入一个元素
	 * @param e
	 * @return
	 */
	public boolean zadd(E e);
	/**
	 * 删除一个数据
	 * @param e
	 * @return
	 */
	public boolean zrem(E e);
	/**
	 *  查找一个数据
	 * @param e
	 * @return
	 */
	public int zrank(E e);
	/**
	 * 按照区间查找数据
	 * @param min
	 * @param max
	 * @return
	 */
	public List zrangebyscore(E min, E max);
}
