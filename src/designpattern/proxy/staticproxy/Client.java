package designpattern.proxy.staticproxy;

public class Client {

	public static void main(String[] args) {
		ISubject realSubject = new RealSubject();
		ISubject proxy = new SubjectProxy(realSubject);
		proxy.doSth();
	}

}
