package project.studentManage.domain;

import project.studentManage.bean.Student;
import project.studentManage.bean.Teacher;
import project.studentManage.utils.Utils;

import java.util.*;

public class    MainApp {
    public static int studentId = 0;
    public static int teacherId = 0;
    public static LinkedList<Student> studentList = new LinkedList<>();
    public static LinkedList<Teacher> teacherList = new LinkedList<>();

    /**
     * Main Menu.
     * <p>
     * This App's Main method is used for controller.
     *
     * @throws java.util.InputMismatchException if input is not number.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.学生管理系统 2.教师管理系统 3.退出");
            System.out.println("请输入您的选择...");
            int firstChose = scanner.nextInt();
            switch (firstChose) {
                case 1:
                    secondLevel(1);
                    break;
                case 2:
                    secondLevel(2);
                    break;
                case 3:
                    System.out.println("退出成功");
                    return;
                default:
                    System.out.println("参数错误请重新选择");
                    break;
            }
        }
    }

    /**
     * Second Level Menu.
     * come from Main Menu. It's used to controller member
     *
     * @param input chose number
     */
    protected static void secondLevel(int input) {
        while (true) {
            String aimType;
            System.out.println("------------------------------------------------------------");
            if (input == 1) {
                System.out.println("1.添加学员 2.修改学员 3.删除学员 4.查询学员 5.返回");
                aimType = "学员";
            } else {
                System.out.println("1.添加教师 2.修改教师 3.删除教师 4.查询教师 5.返回");
                aimType = "教师";
            }
            System.out.println("请输入功能序号...");
            Scanner scanner = new Scanner(System.in);
            int secondChose = scanner.nextInt();
            switch (secondChose) {
                case 1:
                    System.out.println("请输入要添加的" + aimType + "信息：");
                    addMethod(input);
                    break;
                case 2:
                    System.out.println("请输入要修改的" + aimType + "ID：");
                    editMethod(input);
                    break;
                case 3:
                    System.out.println("请输入要删除的" + aimType + "ID：");
                    deleteMethod(input);
                    break;
                case 4:
                    searchMethod(input);
                    break;
                case 5:
                    System.out.println("返回");
                    System.out.println("------------------------------------------------------------");
                    return;
                default:
                    System.out.println("参数错误请重新输入");
                    break;
            }
        }
    }

    /**
     * Add Member.
     * <p>
     * come from Second Menu. It's used to add member.
     *
     * @param input type number
     */
    protected static void addMethod(int input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入姓名...");
        String name = scanner.nextLine();

        System.out.println("请输入性别...");
        String sex = scanner.nextLine();

        System.out.println("请输入生日(格式:2020-12-12)...");
        String birthday = scanner.nextLine();

        Utils tool = new Utils();
        int age = tool.calculateAge(birthday);
        if (age == -1) {
            System.out.println("生日错误，请重试...");
        } else {
            if (input == 1) {
                Student newStudent = new Student(tool.createId(input), name, sex, birthday, age);
                studentList.add(newStudent);
                System.out.println("【成功】学员信息添加成功");
            } else {
                Teacher newTeacher = new Teacher(tool.createId(input), name, sex, birthday, age);
                teacherList.add(newTeacher);
                System.out.println("【成功】教师信息添加成功");
            }
        }
    }

    /**
     * Edit Member.
     * <p>
     * come from Second Menu. It's used to edit member.
     *
     * @param input type number
     */
    protected static void editMethod(int input) {
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        Utils utils = new Utils();
        if (input == 1) {
            Student student = utils.searchStudent(id);
            if (student == null) {
                System.out.println("【错误】学员ID为" + id + "的学员不存在");
            } else {
                utils.editMember(student);
            }
        } else {
            Teacher teacher = utils.searchTeacher(id);
            if (teacher == null) {
                System.out.println("【错误】教师ID为" + id + "的教师不存在");
            } else {
                utils.editMember(teacher);
            }
        }
    }

    /**
     * Search Member.
     * <p>
     * Search all Member about type
     *
     * @param input member type
     */
    protected static void searchMethod(int input) {
        System.out.println("查询结果");
        System.out.println("************************************************************");
        if (input == 1) {
            if (studentList.isEmpty()) {
                System.out.println("无相关学员信息");
            } else {
                for (Student student : studentList) {
                    System.out.println(student.toString());
                    System.out.println("我是一名：" + student.getType());
                    System.out.println("我的工作：" + student.getWork());
                }
            }
        } else {
            if (teacherList.isEmpty()) {
                System.out.println("无相关教师信息");
            } else {
                for (Teacher teacher : teacherList) {
                    System.out.println(teacher.toString());
                    System.out.println("我是一名：" + teacher.getType());
                    System.out.println("我的工作：" + teacher.getWork());
                }
            }

        }
        System.out.println("************************************************************");

    }

    /**
     * Delete Member by Id.
     * <p>
     * use id to delete member
     *
     * @param input type number
     */
    protected static void deleteMethod(int input) {
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        Utils utils = new Utils();
        if (input == 1) {
            Student student = utils.searchStudent(id);
            if (student == null) {
                System.out.println("【错误】学员ID为" + id + "的学员不存在");
            } else {
                utils.deleteMember(student);
            }
        } else {
            Teacher teacher = utils.searchTeacher(id);
            if (teacher == null) {
                System.out.println("【错误】教师ID为" + id + "的教师不存在");
            } else {
                utils.deleteMember(teacher);
            }

        }
    }
}
