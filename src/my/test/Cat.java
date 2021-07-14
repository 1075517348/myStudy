package my.test;

public class Cat extends Animal {
    private int age = 10;
    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }

    @Override
    public void eat() {
        System.out.println("猫粮");
        System.out.println(this);
        System.out.println(this.age);
    }

}
