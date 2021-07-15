package project.studentManage.bean;

public abstract class Person {
    //唯一id编号
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private int age;

    public Person() {
    }

    public Person(int id, String name, String sex, String birthday, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
    }

    @Override
    public String toString() {
        return "编号：" + id + " 姓名：" + name + " 性别：" + sex + " 生日：" + birthday + " 年龄：" + age;
    }

    //返回自身的"类型"字符串。
    public abstract String getType();

    //返回自身的"工作"字符串。
    public abstract String getWork();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
