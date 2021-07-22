package my.MyIO;

public class StudentT {

    private String name;
    private int age;

    //私有构造方法
    private StudentT() {
        System.out.println("我是私有的无参构造方法");
    }

    //公共构造方法
    public StudentT(String name, int age) {
        System.out.println("我是公共的有参构造方法");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentT{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
