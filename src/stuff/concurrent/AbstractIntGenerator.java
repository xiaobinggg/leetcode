package stuff.concurrent;

/**
 * 
 * @author LiuXiaoBing
 *
 */
public abstract class AbstractIntGenerator {
	private volatile boolean canceled = false;

	/**
	 * 生产
	 * 
	 * @return 共享变量
	 */
	public abstract int next();
	public void cancel() { canceled = true;}
	public boolean isCanceled() {return canceled;}

}