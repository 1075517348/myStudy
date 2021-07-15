package my.PowerButton;

import my.test.B;

import java.math.BigInteger;

/**
 * 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围（int类型范围） ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class TwoDayIntReverse {
    public static void main(String[] args) {
    }

    /**
     * 我的傻子解法
     * <p>
     * 算是做错了，因为题目要求不能存储64位整数，而double已经是了
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        StringBuilder str1;
        Integer i = Integer.valueOf(x);
        String fh = "";
        if (x < 0) {
            fh = "-";
            str1 = new StringBuilder(i.toString().substring(1));
        } else {
            str1 = new StringBuilder(i.toString());
        }
        String str = str1.reverse().toString();
        double d = Double.parseDouble(fh + str);
        if (d <= Integer.MAX_VALUE && d >= Integer.MIN_VALUE) {
            return (int) d;
        } else {
            return 0;
        }
    }

    /**
     * 官方正解
     * <p>
     * 时间复杂度：O(log∣x∣)。翻转的次数即 xx 十进制的位数。
     * <p>
     * 空间复杂度：O(1)。
     */
    public int reverseT(int x) {
        int rev = 0;
        while (x != 0) {
            //因为反转过来可能会超过范围，但是不能存储32位以外的数字，也就是不能用long，所以就这么写。
            //int -2147483648~2147483647
            //int/10 -214748364~214748364
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * 我感觉不错的答案
     *
     * @param x
     * @return
     */
    public int reverseF(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //int -2147483648~2147483647
            //int/10 -214748364~214748364
            //如果某个数字大于 214748364那后面就不用再判断了，肯定溢出了。负数也如此
            //其实(res == 214748364 && tmp > 7)不需要判断，因为不存在这样的x，但是思路很重要
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //其实(res == -214748364 && tmp < -8)不需要判断，因为不存在这样的x，但是思路很重要
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
