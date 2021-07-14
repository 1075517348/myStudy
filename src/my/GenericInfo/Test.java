package my.GenericInfo;

public class Test {
    //    static TestT testT = new TestT();
    static Test test = new Test(); //static变量是属于类的，不属于哪一个特定的对像。 只初始化一次。
    static int it = 2;

    {
        System.out.println("非静态代码块" + it);
    }

    static {
        System.out.println("静态代码块" + (it + 1));
    }
}
