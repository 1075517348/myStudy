package my.MyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTest {
    public static void main(String[] args) {
        //创建郝女士对象
        GoodLady gl = new GoodLady();
        //普通代理模式
        method1(gl);
        System.out.println("--------");
        //动态代理模式
        method2();
    }

    public static void method2() {
        //获取动态代理对象
        Object o = (FindHusband) Proxy.newProxyInstance(GoodLady.class.getClassLoader(), GoodLady.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //不能在invoke中使用proxy调用该对象的方法， 调用方法的时候，会触发invoke执行，导致出现递归死循环。
                // System.out.println(proxy.toString());//java.lang.StackOverflowError
                System.out.println("物色合适的人");
                System.out.println("安排相亲约会的场地");
                GoodLady gl = GoodLady.class.getConstructor().newInstance();
                String a = gl.findHusband2();
                System.out.println("分析约会结果");
                System.out.println("后续服务...");
                return a;
            }
        });
        //调用无返回值方法
        FindHusband fh = (FindHusband) o;
        fh.findHusband();
        //调用有返回值方法
        FindHusband2 fh2 = (FindHusband2) o;
        System.out.println(fh2.findHusband2());
    }

    public static void method1(GoodLady gl) {
        HunJieSuo hjs = new HunJieSuo(gl);
        hjs.findHusband();
    }
}
