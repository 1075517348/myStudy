package my.oopWork;


public class AllTestClass {
    final int i = 1;
    static int a = 2;
    String str = new String("good");

    public static void main(String[] args) {
        /*
        Rectangle rectangle = new Rectangle(2.5, 4.4);
        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());
*/
        /*AllTestClass allTestClass = new AllTestClass();
        allTestClass.testMethod(allTestClass.str);
        System.out.println(allTestClass.str);
        int i = 0;
        for (returnTrue(); i < 10; i++) {
            System.out.println(1);
        }*/
        /*Employee employee = new Employee("梁文浩", 8100.00, new MyDate("2018", "8", "15"));
        employee.show();*/
        /*Shape shape = new Roundness(3 / Math.PI);
        System.out.println(shape.area());

        shape = new Square(2);
        System.out.println(shape.area());

        shape = new Triangle(90, 3, 4);
        System.out.println(shape.area());*/
        /*Object[] objectArr = new Object[5];
        objectArr[0] = new Roundness();
        objectArr[1] = new Square();
        objectArr[2] = new Triangle();
        objectArr[3] = Float.valueOf(1.2F);
        objectArr[4] = Double.valueOf(2.4);*/
        try{
            String str = "lili";
            System.out.println(str);
            int age = Integer.parseInt("18S");
            System.out.println(age);
        }catch(Exception e){
            System.out.println("test");
            e.printStackTrace();
        }
        System.out.println("TestOver");

    }

    public static boolean returnTrue() {
        return true;
    }

    public static void testMethod(String str) {
        str = "aaa";
    }
}
