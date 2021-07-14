package my.test;

public class Dog extends Animal {
    public void lookHome() {
        System.out.println("狗看家");
    }

    @Override
    public void eat() {
        System.out.println("shit");
    }
}
