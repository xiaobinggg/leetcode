package stuff.concurrent;

/**
 * EvenGenerator
 * @author lenovo
 *
 */
public class EvenGenerator extends AbstractIntGenerator {
	private int currentEvenValue = 0;
	@Override
	public int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}

}
