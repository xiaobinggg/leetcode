package algorithms.skiplist;

import java.util.Random;

/**
 * @Description:
 * @author:LiuXiaoBing
 * @date: 2019年8月29日 下午4:51:12
 */
public class BingSkipList<E> {
	private static final int MAX_LEVEL = 10;
	/**
	 * 跳表最大层级
	 */
	private int currentMaxLevel = 1;

	private Random r = new Random();
	public SkipNode<E> head = new SkipNode<E>(null, 0, MAX_LEVEL);

	/**
	 * 查找元素
	 * @param e
	 * @return
	 */
	public SkipNode<E> find(E e) {
		SkipNode<E> p = head;
		for (int i = currentMaxLevel - 1; i >= 0; i -= 1) {
			while (p.forwards[i] != null && p.forwards[i].hashcode < e.hashCode()) {
				p = p.forwards[i];
			}
		}
		if (p.forwards[0] != null && p.forwards[0].hashcode == e.hashCode()) {
			return p.forwards[0];
		} else {
			return null;
		}
	}

	public void insert(E e) {
		int nodeLevel = this.getRandomLevel();
		SkipNode<E> node = new SkipNode<E>(e, nodeLevel, MAX_LEVEL);
		this.currentMaxLevel = this.currentMaxLevel > nodeLevel ? this.currentMaxLevel : nodeLevel;
		SkipNode<E> p = head;
		for (int i = nodeLevel - 1; i >= 0; i -= 1) {
			while (p.forwards[i] != null && p.forwards[i].hashcode < e.hashCode()) {
				p = p.forwards[i];
			}
			node.forwards[i] = p.forwards[i];
			p.forwards[i] = node;
		}
	}

	public void delete(E e) {
		SkipNode<E>[] updates = new SkipNode[currentMaxLevel];
		SkipNode<E> p = head;
		for (int i = currentMaxLevel - 1; i >= 0; i -= 1) {
			while (p.forwards[i] != null && p.forwards[i].hashcode < e.hashCode()) {
				p = p.forwards[i];
			}
			updates[i] = p;
		}
		if (p.forwards[0] != null && p.forwards[0].hashcode == e.hashCode()) {
			for (int i = currentMaxLevel - 1; i >= 0; i -= 1) {
				if (updates[i].forwards[i] != null && updates[i].forwards[i].hashcode == e.hashCode()) {
					updates[i].forwards[i] = updates[i].forwards[i].forwards[i];
				}
			}
		}
		while (currentMaxLevel > 1 && head.forwards[currentMaxLevel] != null) {
			currentMaxLevel -= 1;
		}
	}

	/**
	 * 获取随机层级，避免跳表退化
	 * @return
	 */
	private int getRandomLevel() {
		int level = 1;
		for (int i = 0; i < MAX_LEVEL; i++) {
			if (r.nextInt() % 2 == 0) {
				level += 1;
			}
		}
		return level;
	}

	public void printAll() {
		SkipNode<E> p = head;
		for (int i = currentMaxLevel - 1; i >= 0; i -= 1) {
			p = head;
			while (p != null) {
				String str = p.data == null ? "null" : p.data.toString();
				System.out.print(str.length() > 1 ? str : "0" + str);
				SkipNode<E> temp = p;
				int count = 0;
				while (temp != p.forwards[i]) {
					temp = temp.forwards[0];
					count += 1;
				}
				p = p.forwards[i];
				while (count > 0) {
					if(count>1) {
						System.out.print("-----");
					}else {
						System.out.print("-->");
					}
					count--;
				}
			}
			System.out.println("");
		}
	}

}
