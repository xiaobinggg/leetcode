package stuff.concurrent;

public class SynchronizedEventGenerator extends AbstractIntGenerator{

	private int currentEvenValue = 0;
	@Override
	public synchronized int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args) {
		EvenChecker.test(new SynchronizedEventGenerator());
	}
}
