package my.test;

public abstract class Animal {
    private String name;
    private double weight;

    public Animal() {
    }

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
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

    public abstract void eat();

    public static void fuck()
    {
        System.out.println("想睡觉");
    }

}
