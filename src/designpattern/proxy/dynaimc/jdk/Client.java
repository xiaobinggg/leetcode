package designpattern.proxy.dynaimc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		ISubject realSubject = new RealSubject();
		InvocationHandler proxyHandler = new SubjectProxyHandler(realSubject);
		ISubject proxy = (ISubject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), proxyHandler);
		proxy.doSth();
	}

}
