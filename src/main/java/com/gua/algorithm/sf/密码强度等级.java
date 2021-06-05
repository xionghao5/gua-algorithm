package com.gua.algorithm.sf;

import java.util.Scanner;

/**
 * 描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * <p>
 * 一、密码长度:
 * <p>
 * 5 分: 小于等于4 个字符
 * <p>
 * 10 分: 5 到7 字符
 * <p>
 * 25 分: 大于等于8 个字符
 * <p>
 * 二、字母:
 * <p>
 * 0 分: 没有字母
 * <p>
 * 10 分: 全都是小（大）写字母
 * <p>
 * 20 分: 大小写混合字母
 * <p>
 * 三、数字:
 * <p>
 * 0 分: 没有数字
 * <p>
 * 10 分: 1 个数字
 * <p>
 * 20 分: 大于1 个数字
 * <p>
 * 四、符号:
 * <p>
 * 0 分: 没有符号
 * <p>
 * 10 分: 1 个符号
 * <p>
 * 25 分: 大于1 个符号
 * <p>
 * 五、奖励:
 * <p>
 * 2 分: 字母和数字
 * <p>
 * 3 分: 字母、数字和符号
 * <p>
 * 5 分: 大小写字母、数字和符号
 * <p>
 * 最后的评分标准:
 * <p>
 * >= 90: 非常安全
 * <p>
 * >= 80: 安全（Secure）
 * <p>
 * >= 70: 非常强
 * <p>
 * >= 60: 强（Strong）
 * <p>
 * >= 50: 一般（Average）
 * <p>
 * >= 25: 弱（Weak）
 * <p>
 * >= 0:  非常弱
 * <p>
 * <p>
 * 对应输出为：
 * <p>
 * VERY_SECURE
 * <p>
 * SECURE,
 * <p>
 * VERY_STRONG,
 * <p>
 * STRONG,
 * <p>
 * AVERAGE,
 * <p>
 * WEAK,
 * <p>
 * VERY_WEAK,
 * <p>
 * <p>
 * 请根据输入的密码字符串，进行安全评定。
 * <p>
 * 注：
 * <p>
 * 字母：a-z, 字符串只换填一次使字符串最小-Z
 * <p>
 * 数字：-9
 * <p>
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * <p>
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 * <p>
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 * <p>
 * [\]^_`              (ASCII码：x5B~0x60)
 * <p>
 * {|}~                (ASCII码：x7B~0x7E)
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * 本题含有多组输入样例。
 * 每组样例输入一个string的密码
 * <p>
 * 输出描述：
 * 每组样例输出密码等级
 * <p>
 * 示例1
 * 输入：
 * 38$@NoNoNo
 * 123
 * 输出：
 * VERY_SECURE
 * WEAK
 * 说明：
 * 第一组样例密码强度为95分。
 * 第二组样例密码强度为25分。
 */
public class 密码强度等级 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            System.out.println(func(a));
        }
    }

    public static String func(String a) {
        int sum = length(a) + zimu(a) + shuzi(a) + fuhao(a) + jiangli(a);
        if (sum >= 90) {
            return "VERY_SECURE";
        }
        if (sum >= 80) {
            return "SECURE";
        }
        if (sum >= 70) {
            return "VERY_STRONG";
        }
        if (sum >= 60) {
            return "STRONG";
        }
        if (sum >= 50) {
            return "AVERAGE";
        }
        if (sum >= 25) {
            return "WEAK";
        }
        return "VERY_WEAK";
    }

    public static int length(String a) {
        if (a.length() <= 4) {
            return 5;
        }
        if (a.length() >= 5 && a.length() <= 7) {
            return 10;
        }
        return 25;
    }

    public static int zimu(String a) {
        int smallCount = 0;
        int bigCount = 0;
        for (char ch : a.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                smallCount++;
            }
            if (ch >= 'A' && ch <= 'Z') {
                bigCount++;
            }
        }
        if ((smallCount + bigCount) == 0) {
            return 0;
        }
        if (smallCount > 0 && bigCount == 0) {
            return 10;
        }
        if (smallCount == 0 && bigCount > 0) {
            return 10;
        }
        return 20;
    }

    public static int shuzi(String a) {
        int count = 0;
        for (char ch : a.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                count++;
            }
        }
        if (count > 1) {
            return 20;
        }
        if (count == 1) {
            return 10;
        }
        return 0;
    }

    public static int fuhao(String a) {
        int count = 0;
        for (char ch : a.toCharArray()) {
            if (ch >= 0x21 && ch <= 0x2F
                    || ch >= 0x3A && ch <= 0x40
                    || ch >= 0x5B && ch <= 0x60
                    || ch >= 0x7B && ch <= 0x7E) {
                count++;
            }
        }
        if (count > 1) {
            return 25;
        }
        if (count == 1) {
            return 10;
        }
        return 0;
    }

    public static int jiangli(String a) {
        if (zimu(a) == 20 && shuzi(a) >= 10 && fuhao(a) >= 10) {
            return 5;
        }
        if (zimu(a) >= 10 && shuzi(a) >= 10 && fuhao(a) >= 10) {
            return 3;
        }
        if (zimu(a) >= 10 && shuzi(a) >= 10) {
            return 2;
        }
        return 0;
    }
}
