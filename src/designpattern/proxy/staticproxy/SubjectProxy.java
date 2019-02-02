package designpattern.proxy.staticproxy;

public class SubjectProxy implements ISubject {
	private ISubject target;
	public SubjectProxy(ISubject target) {
		this.target = target;
	}

	@Override
	public void doSth() {
		System.out.println("拦截到方法被调用");
		this.target.doSth();
	}

}
