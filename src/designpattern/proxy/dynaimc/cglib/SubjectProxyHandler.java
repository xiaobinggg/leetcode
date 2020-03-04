/*package designpattern.proxy.dynaimc.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SubjectProxyHandler implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
		 System.out.println("Before Method Invoke");
	        proxy.invokeSuper(object, args);
	        System.out.println("After Method Invoke");
	        return object;
	}
}
*/