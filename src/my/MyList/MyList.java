package my.MyList;

import java.text.SimpleDateFormat;
import java.util.*;

public class MyList {
    public static void main(String[] args) {
        Emp e1 = new Emp("01", "梁文浩1");
        Emp e2 = new Emp("02", "梁文浩2");
        Emp e3 = new Emp("03", "梁文浩3");
        Emp e5 = new Emp("05", "梁文浩5");
        Emp e6 = new Emp("06", "梁文浩6");
        Map<String, String> map = new HashMap<>();
        map.put(e1.getId(), e1.getName());
        map.put(e2.getId(), e2.getName());
        map.put(e3.getId(), e3.getName());
        map.put(e5.getId(), e5.getName());
        map.put(e6.getId(), e6.getName());

        for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            if (key.equals("05")) {
                iterator.remove();
            }
        }
        //可以这样遍历查看是否已经删除
        for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            System.out.println(key);
        }


    }
}
