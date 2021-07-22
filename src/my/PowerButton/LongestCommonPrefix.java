package my.PowerButton;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * <p>
 * 0 <= strs[i].length <= 200
 * <p>
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abab", "aba", ""};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 我的答案
     *
     * @param strs 输入一个字符串数组
     * @return 公告前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        //如果字符串数组为空直接返回无
        int length = strs.length;
        if (length == 0 || strs[0].equals("")) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }
        //获取最短的元素的Index
        int index = 0;
        //中间量，此处获取第一个元素的第一个字符
        String cen = strs[0].substring(0, 1);
        for (int i = 1; i < strs.length; i++) {
            //如果循环一次发现有空的直接返回无了
            if (strs[i].equals("")) {
                return "";
            }
            //如果第一循环就出现有开头不是指定字符串的就直接返回空
            if (!strs[i].startsWith(cen) && i == 1) {
                return "";
            }
            //存在小于第一个长度的，就替换
            if (strs[i].length() < strs[index].length()) {
                index = i;
            }
        }
        //当前最短的元素长度
        int shortStrLength = strs[index].length();
        //上方情况通过就执行多次循环
        for (int i = 1; i <= shortStrLength; i++) {
            //更新目前前缀
            cen = strs[0].substring(0, i);
            for (String str : strs) {
                if (!str.startsWith(cen)) {
                    if (cen.length() == 1) {
                        return "";
                    }
                    return cen.substring(0, cen.length() - 1);
                }
            }
        }
        return cen;
    }

    /**
     * 官方解法1-- 横向扫描
     *
     * <p>
     * 依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
     * <p>
     * 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * <p>
     * 空间复杂度：O(1)。使用的额外空间复杂度为常数。
     */
    public String longestCommonPrefixT(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * 求前缀
     *
     * @param str1
     * @param str2
     * @return 返回前缀字符串
     */
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 官方解法2--纵向扫描
     * <p>
     * 另一种方法是纵向扫描。纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     * <p>
     * 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * <p>
     * 空间复杂度：O(1)。使用的额外空间复杂度为常数。
     */
    public String longestCommonPrefixTT(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        //循环第一个数组长度
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            //循环传入数组--因为第一个元素用了，所以不需要循环了
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 官方解法3--分治
     */
    public String longestCommonPrefixTTT(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            //获取数组中间的数字
            int mid = (end - start) / 2 + start;
            //变成左边-再次调用自身
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            //变成右边-再次调用自身
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        //获取前缀
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    /**
     * 官方解法4--二分查找
     */
    public String longestCommonPrefixTTTT(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //求出数组长度最短的值
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        //最短字符串长度high
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
