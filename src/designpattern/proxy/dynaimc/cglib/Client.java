/*package designpattern.proxy.dynaimc.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Client {

	public static void main(String[] args) {
		
		SubjectProxyHandler proxyHandler = new SubjectProxyHandler();
		 Enhancer enhancer = new Enhancer();
		 enhancer.setSuperclass(RealSubject.class);
	     enhancer.setCallback(proxyHandler);
	     RealSubject proxy = (RealSubject) enhancer.create();
	     proxy.doSth();
	     
	}

}*/
