package designpattern.proxy.dynaimc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxyHandler implements InvocationHandler {
	private Object target = null;
	public SubjectProxyHandler(Object _obj) {
		this.target = _obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("拦截到方法被调用");
		return method.invoke(this.target, args);
	}

}
