package designpattern.proxy.dynaimc.jdk;

public class RealSubject implements ISubject {

	@Override
	public void doSth() {
		System.out.println("真实对象方法被调用");
	}

}
