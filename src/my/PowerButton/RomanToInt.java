package my.PowerButton;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    /**
     * 输入罗马数字求整数
     * <p>
     * 我写的就是个傻逼
     *
     * @param s 输入的罗马数字
     * @return 返回对应的整数
     */
    public static int romanToInt(String s) {
        //先定义字符串长度，并判断以防超出长度
        int length = s.length();
        if (length < 1 || length > 15) {
            return -1;
        }
        //生成一个Map集合来存储
        Map<String, Integer> map = new HashMap<>();
        //将对应数据插入集合
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        //一个合数
        int sum = 0;
        //两个字符
        Character a;
        Character b;
        //一个字符串
        String str;
        //一个数字
        Integer sumInt;
        //判断字符串每一位对应什么
        for (int i = 0; i < length; i++) {
            a = s.charAt(i);
            //当是最后一个字符串的时候获取前一个
            if (i != length - 1) {
                b = s.charAt(i + 1);
                str = a.toString() + b.toString();
            } else {
                str = a.toString();
            }
            sumInt = map.get(str);
            if (sumInt != null) {
                sum += sumInt;
                i++;
                continue;
            }
            sumInt = map.get(a.toString());
            if (sumInt != null) {
                sum += sumInt;
            }
        }
        return sum;
    }

    /**
     * 官方解法
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
     * <p>
     * 例如 XXVII 可视作 X+X+V+I+I=10+10+5+1+1=27
     * <p>
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
     * <p>
     * 例如 XIV 可视作 X-I+V=10-1+5=14
     */
    public int romanToIntT(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

}
