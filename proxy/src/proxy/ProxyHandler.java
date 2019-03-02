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
		//AOP���
		//�ڵ��þ��庯������ǰ��ִ�й��ܴ���
		result = method.invoke(obj, args);
		//�ڵ��þ��庯��������ִ�й��ܴ���
		return result;
	}

}
