package my.oopWork;

public class Employee {
    private String name;
    private double salary;
    private MyDate inviteTime;

    public Employee(String name, double salary, MyDate inviteTime) {
        this.name = name;
        this.salary = salary;
        this.inviteTime = inviteTime;
    }

    public Employee() {
    }

    public void show() {
        System.out.println("姓名：" + name + "，薪资:" + salary + "，入职日期：" + inviteTime.show());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(MyDate inviteTime) {
        this.inviteTime = inviteTime;
    }
}
