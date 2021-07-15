package project.studentManage.utils;

import project.studentManage.bean.Student;
import project.studentManage.bean.Teacher;
import project.studentManage.domain.MainApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class {@code Utils} is a toolkit.
 *
 * <p>include some method to creat id,printing {@link Student} or {@link Teacher},calculate the age.
 *
 * @author Servant
 * @version 1.0
 * @since 1.0
 */
public class Utils {

    /**
     * Create {@link Student} / {@link Teacher} ID.
     * <p>
     * without repetition id for {@link Student} / {@link Teacher}
     *
     * @param type type number
     */
    public int createId(int type) {
        int result;
        if (type == 1) {
            result = ++MainApp.studentId;
        } else {
            result = ++MainApp.teacherId;
        }
        return result;
    }

    /**
     * Calculate Age
     * <p>
     * use birthday to Calculate ages
     * use {@link SimpleDateFormat} , {@link Date} and {@link GregorianCalendar} to calculate
     *
     * @param birthday String date
     */
    public int calculateAge(String birthday) {
        int age;
        //定义日历对象
        GregorianCalendar gre = new GregorianCalendar();
        //Calendar gret = Calendar.getInstance(); 可以用这种方法定义对象也可
        //用当前日历获取对应年月日
        int nowYear = gre.get(Calendar.YEAR);
        int nowMonth = gre.get(Calendar.MONTH);
        int nowDay = gre.get(Calendar.DAY_OF_MONTH);
        try {
            //此类可以在Date对象与String对象之间切换
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            //用传入的字符串生成了对应的日期对象
            Date birthDate = sim.parse(birthday);
            //将出生日期对象转换日历获取对应年月日
            gre.setTime(birthDate);
            int birthYear = gre.get(Calendar.YEAR);
            int birthMonth = gre.get(Calendar.MONTH);
            int birthDay = gre.get(Calendar.DAY_OF_MONTH);
            //进行合法年龄判断，此处为了可读性就不合并了
            if (birthYear > nowYear) { //出生年不可大于当前年
                age = -1;
            } else if (birthYear == nowYear && birthMonth > nowMonth) {//出生年相同，出生月份不可大于当前月份
                age = -1;
            } else if (birthYear == nowYear && birthMonth == nowMonth && birthDay > nowDay) { //出生年月相同，出生日不可大于当前日
                age = -1;
            }
            //合法的情况下计算年龄
            if (birthMonth < nowMonth || (nowDay > birthDay && birthMonth == nowMonth)) {
                age = nowYear - birthYear;
            } else {
                age = nowYear - birthYear - 1;
            }
            return age;
        } catch (ParseException e) {
            return -1;
        }
    }

    /**
     * Use id search the student.
     * <p>
     * use student's id search a student,it will return {@link Student}.
     *
     * @param id Student's ID
     */
    public Student searchStudent(int id) {
        Student returnStudent = null;
        for (Student student : MainApp.studentList) {
            if (student.getId() == id) {
                System.out.println("【查询结构】ID所属的学员信息");
                System.out.println("************************************************************");
                System.out.println(student.toString());
                System.out.println("我是一名：" + student.getType());
                System.out.println("我的工作：" + student.getWork());
                System.out.println("************************************************************");
                returnStudent = student;
            }
        }
        return returnStudent;
    }

    /**
     * Use id search the teacher.
     * <p>
     * use teacher's id search a teacher,it will return {@link Teacher}.
     *
     * @param id Teacher's ID
     */
    public Teacher searchTeacher(int id) {
        Teacher returnTeacher = null;
        for (Teacher teacher : MainApp.teacherList) {
            if (teacher.getId() == id) {
                System.out.println("【查询结构】ID所属的教师信息");
                System.out.println("************************************************************");
                System.out.println(teacher.toString());
                System.out.println("我是一名：" + teacher.getType());
                System.out.println("我的工作：" + teacher.getWork());
                System.out.println("************************************************************");
                returnTeacher = teacher;
            }
        }
        return returnTeacher;
    }

    /**
     * Delete Member(Student)
     * <p>
     * use to delete a member(student)
     *
     * @param student {@link Student}
     */
    public void deleteMember(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("【确认】您要删除这条信息么（y/n）?");
        String sureInfo = scanner.nextLine();
        if ("y".equals(sureInfo)) {
            boolean delete = MainApp.studentList.remove(student);
            if (delete) {
                System.out.println("【成功】数据已被删除");
            } else {
                System.out.println("【错误】发生未知错误，请重试...");
            }
        } else {
            System.out.println("【取消】操作被取消");
        }
    }

    /**
     * Delete Member(Teacher)
     * <p>
     * use to delete a member(teacher)
     *
     * @param teacher {@link Teacher}
     */
    public void deleteMember(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("【确认】您要删除这条信息么（y/n）?");
        String sureInfo = scanner.nextLine();
        if (sureInfo.equals("y")) {
            boolean delete = MainApp.studentList.remove(teacher);
            if (delete) {
                System.out.println("【成功】数据已被删除");
            } else {
                System.out.println("【错误】发生未知错误，请重试...");
            }
        } else {
            System.out.println("【取消】操作被取消");
        }
    }

    /**
     * Edit Member(Student)
     * <p>
     * edit student's info
     *
     * @param student {@link Student}
     */
    public void editMember(Student student) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入修改姓名...");
            String name = scanner.nextLine();

            System.out.println("请输入修改性别...");
            String sex = scanner.nextLine();

            System.out.println("请输入修改生日(格式:2020-12-12)...");
            String birthday = scanner.nextLine();

            Utils tool = new Utils();
            int age = tool.calculateAge(birthday);
            if (age == -1) {
                System.out.println("生日错误，请重试...");
            } else {
                student.setName(name);
                student.setBirthday(birthday);
                student.setSex(sex);
                student.setAge(age);
                System.out.println("【成功】学员信息修改成功");
                break;
            }
        }
    }

    /**
     * Edit Member(Teacher)
     * <p>
     * edit teacher's info
     *
     * @param teacher {@link Teacher}
     */
    public void editMember(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入修改姓名...");
            String name = scanner.nextLine();

            System.out.println("请输入修改性别...");
            String sex = scanner.nextLine();

            System.out.println("请输入修改生日(格式:2020-12-12)...");
            String birthday = scanner.nextLine();

            Utils tool = new Utils();
            int age = tool.calculateAge(birthday);
            if (age == -1) {
                System.out.println("生日错误，请重试...");
            } else {
                teacher.setName(name);
                teacher.setBirthday(birthday);
                teacher.setSex(sex);
                teacher.setAge(age);
                System.out.println("【成功】学员信息修改成功");
                break;
            }
        }
    }
}
