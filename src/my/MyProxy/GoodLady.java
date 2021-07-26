package my.MyProxy;

public class GoodLady implements FindHusband, FindHusband2 {
    @Override
    public void findHusband() {
        System.out.println("相亲...约会...聊天...");
    }

    @Override
    public String findHusband2() {
        System.out.println("相亲...约会...聊天...");
        return "ok2";
    }
}
