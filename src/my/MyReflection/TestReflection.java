package my.MyReflection;

public class TestReflection {
    //注释字段
    @Field_Method_Parameter_Annotation(describe = "编号", type = int.class)
    int id;
    //注释字段
    @Field_Method_Parameter_Annotation(describe = "姓名", type = String.class)
    String name;
    //用默认值注释构造方法
    @Constructor_Annotation
    public TestReflection() {

    }
    //注释构造方法
    @Constructor_Annotation("立即初始化构造方法")
    public TestReflection(@Field_Method_Parameter_Annotation(describe = "编号", type = int.class) int id, @Field_Method_Parameter_Annotation(describe = "姓名", type = String.class) String name) { //注释形参里的字段
        this.id = id;
        this.name = name;
    }
    //注释方法
    @Field_Method_Parameter_Annotation(describe = "获取编号", type = int.class)
    public int GetId() {
        return id;
    }
}
