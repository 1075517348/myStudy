package my.oopWork;

public class Child extends Father {
    @Override
    public void sleep() {
        System.out.println("子，睡觉");
    }

    public void myEat() {
        System.out.println("子自身吃东西");
    }
}
