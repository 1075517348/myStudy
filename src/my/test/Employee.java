package my.test;

public class Employee {
    private String name;
    private double Salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}
