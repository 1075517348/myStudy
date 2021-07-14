package my.test;

public class Company implements Money {
    private double allMoney = 1000000.00;

    public double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(double allMoney) {
        this.allMoney = allMoney;
    }

    @Override
    public void paySalary(Employee e) {
        allMoney -= e.getSalary();
        System.out.println("给" + e.getName() + "发工资" + e.getSalary() + "元，公司剩余" + allMoney + "元。");
    }
}
