package my.GenericInfo;

import my.test.A;

import java.util.*;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printInfo() {
        System.out.println(name + "\t" + age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        //第一个形参是后面的元素，第二个形参是前面的元素
        return o1.age - o2.age;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Student s1 = new Student("A", 25);
        Student s2 = new Student("B", 20);
        Student s3 = new Student("C", 22);
        List<Student> a = new ArrayList<>();
        a.add(s1);
        a.add(s2);
        a.add(s3);
        System.out.println(a);
        //对年龄排序
        AgeComparator nc2 = new AgeComparator();
        Collections.sort(a, nc2);
        for (Student o : a) {
            o.printInfo();
        }
        //按名字排序，以创建匿名类的方式实现
        Collections.sort(a, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Student o : a) {
            o.printInfo();
        }
    }
}
