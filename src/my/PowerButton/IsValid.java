package my.PowerButton;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * <p>
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 1 <= s.length <= 104
 * <p>
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {
    public static void main(String[] args) {
        String[] strs = {"()", "()[]{}", "(]", "([][](", "([)]", "{[]}", "(", ")", "(){}}{"};
//        String[] strs = {"(){}}{"};
            System.out.println(isValidT("([)]"));
    }

    /**
     * 有效的括号
     * <p>
     * 我没做出来，难顶。
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('(', 1);
            put(')', -1);
            put('{', 2);
            put('}', -2);
            put('[', 3);
            put(']', -3);
        }};
        int length = s.length();
        a:
        for (int i = 0; i < length - 1; ) {
            //前一个和后一个不匹配"{[]}"
            if (map.get(s.charAt(i)) + map.get(s.charAt(i + 1)) != 0) {
                int j = i + 3;
                while (j < length) {
                    if (map.get(s.charAt(i)) + map.get(s.charAt(j)) != 0) {
                        j += 3;
                        continue;
                    }
                    i += 1;
                    continue a;
                }
                return false;
            }
            i += 2;
        }
        return true;
    }

    /**
     * 判断括号的有效性可以使用「栈」这一数据结构来解决。
     * <p>
     * 我们遍历给定的字符串 ss。当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。
     * <p>
     * 当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是相同的类型，或者栈中并没有左括号，那么字符串 ss 无效，返回 False。为了快速判断括号的类型，我们可以使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。
     * <p>
     * 在遍历结束后，如果栈中没有左括号，说明我们将字符串 s 中的所有左括号闭合，返回 True，否则返回 False。
     * <p>
     * 注意到有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程。
     *
     * @param s
     * @return
     */
    public static boolean isValidT(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        //先用集合存储
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        //生成一个链表结构
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //查询集合里有无此元素，有就继续
            if (pairs.containsKey(ch)) {
                //如果链表为空，或者链表获取表头不等于对应闭合的。就返回错
                if (stack.isEmpty() || stack.getFirst() != pairs.get(ch)) {
                    return false;
                }
                //弹出元素
                stack.pop();
            } else {
                //插入元素
                stack.push(ch);
            }
        }
        //返回链表是否为空
        return stack.isEmpty();
    }
}
