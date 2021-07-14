package project.studentManage;

public class Teacher extends Person {
    public Teacher() {
        super();
    }

    public Teacher(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    @Override
    public String getType() {
        return "老师";
    }

    @Override
    public String getWork() {
        return "教课";
    }
}
