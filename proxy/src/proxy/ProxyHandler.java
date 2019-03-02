package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler{

	private Object obj;
	
	public Object bind(Object obj) {
		
		this.obj = obj;
		return Proxy.newProxyInstance(
				obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), 
				this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		//AOP编程
		//在调用具体函数方法前，执行功能处理
		result = method.invoke(obj, args);
		//在调用具体函数方法后，执行功能处理
		return result;
	}

}
