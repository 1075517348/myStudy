package my.InterfaceInfo;

public class Orange extends Fruit {
    @Override
    public void howToEat() {
        System.out.println("吃橙子");
    }

    @Override
    public String toString() {
        return "Orange{}";
    }
}
