package project.studentManage.bean;


public class Student extends Person {
    public Student() {
        super();
    }

    public Student(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    @Override
    public String getType() {
        return "学生";
    }

    @Override
    public String getWork() {
        return "学习";
    }
}
