package my.GenericInfo;

public class TestComparable implements Comparable<TestComparable> {
    String name;
    int age;

    public TestComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void printInfo(){
        System.out.println(age);
    }
    @Override
    public int compareTo(TestComparable o) {
        return this.age - o.age;
    }
}
