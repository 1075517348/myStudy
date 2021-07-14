package my.InterfaceInfo;

public class Chicken extends Animal implements Eatable {
    @Override
    public void howToEat() {
        System.out.println("油炸清蒸");
    }
}
