package my.test;

public class T extends B{
    public A a = new A();
    {
        System.out.println("tt");
    }
    static {
        System.out.println("static tt");
    }
    public T() {
        System.out.println("T info ");
    }
}
