package my.MyProxy;

public class HunJieSuo implements FindHusband {
    public GoodLady gl;

    public HunJieSuo(GoodLady gl) {
        this.gl = gl;
    }

    @Override
    public void findHusband() {
        System.out.println("物色合适的人");
        System.out.println("安排相亲约会的场地");
        gl.findHusband();
        System.out.println("分析约会结果");
        System.out.println("后续服务...");
    }
}