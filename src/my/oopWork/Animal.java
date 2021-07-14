package my.oopWork;

public class Animal {
    private String name;
    private double weight;

    public Animal() {
    }

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void run() {
        System.out.println("跑");
    }

    public void jump() {
        System.out.println("跳");
    }

    public void walk() {
        System.out.println("走");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
