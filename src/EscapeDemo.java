/**
 * @Description: 不正确构造对象示例
 * @author:LiuXiaoBing
 * @date: 2019年8月17日 上午10:17:58
 */
public class EscapeDemo {
	private String id;

	public EscapeDemo(String id) {
		// 在构造函数中创建一个线程并启动， 线程执行时外部类对象很可能还未构造完成
		Thread t = new Thread() {
			public void run() {
				System.out.println(getId());
			}
		};
		t.start();
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
}
