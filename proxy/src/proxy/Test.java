package proxy;

public class Test {
	public static void main(String[] args) {
		ProxyHandler proxy = new ProxyHandler();
		Subject sub = (Subject)proxy.bind(new RealSubject());
		sub.doSomething();
	}
}
