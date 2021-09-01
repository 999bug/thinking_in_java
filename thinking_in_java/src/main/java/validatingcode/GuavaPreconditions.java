package validatingcode;// validating/GuavaPreconditions.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrating Guava Preconditions

import java.util.function.Consumer;

import static com.google.common.base.Preconditions.*;

public class GuavaPreconditions {
    static int i = 1;
    static int i2 = 1;
    static String flag2 = "error_";
    static String flag1 = "success_";

    static void test(Consumer<String> c, String s) {
        try {
            System.out.println(s);
            c.accept(s);
            System.out.println(flag1 + i++);
        } catch (Exception e) {
            String type = e.getClass().getSimpleName();
            String msg = e.getMessage();
            System.out.println(flag2 + i2++ + "_: " + type +
                    (msg == null ? "" : ": " + msg));
        }
    }

    // TODO: 2021/9/1 Goava 前置条件
    public static void main(String[] args) {
        test(s -> s = checkNotNull(s), "X");
        test(s -> s = checkNotNull(s), null);
        test(s -> s = checkNotNull(s, "s was null"), null);
        test(s -> s = checkNotNull(
                s, "s was null, %s %s", "arg2", "arg3"), null);
        System.out.println("=======");
        System.out.println("=======");
        System.out.println("=======");
        // TODO: 2021/9/1 checkArgument()接收布尔表达式来对参数进行更具体的测试 ，失败抛出IllegalArgumentException
        test(s -> checkArgument(s == "Fozzie"), "Fozzie");
        test(s -> checkArgument(s == "Fozzie"), "X");
        test(s -> checkArgument(s == "Fozzie"), null);
        test(s -> checkArgument(
                s == "Fozzie", "Bear Left!"), null);
        test(s -> checkArgument(
                s == "Fozzie", "Bear Left! %s Right!", "Frog"),
                null);
        System.out.println("=======");
        System.out.println("=======");
        System.out.println("=======");
        // TODO: 2021/9/1 checkState（expression）获取表达式的状态
        test(s -> checkState(s.length() > 6), "Mortimer");
        test(s -> checkState(s.length() > 6), "Mort");
        test(s -> checkState(s.length() > 6), null);
        System.out.println("=======");
        System.out.println("=======");
        System.out.println("=======");
        // TODO: 2021/9/1 checkElementIndex(a,b) 确保 a 是b 有效元素索引，大小由b 指定
        test(s ->
                checkElementIndex(6, s.length()), "Robert");
        test(s ->
                checkElementIndex(5, s.length()), "Robert");
        test(s ->
                checkElementIndex(6, s.length()), "Bob");
        test(s ->
                checkElementIndex(6, s.length()), null);
        System.out.println("=======");
        System.out.println("=======");
        System.out.println("=======");
        // TODO: 2021/9/1 checkPositionindex(index,b) 确保 index 在 0到 b.length 范围内
        test(s ->
                checkPositionIndex(3, s.length()), "Robert");
        test(s ->
                checkPositionIndex(6, s.length()), "Robert");
        test(s ->
                checkPositionIndex(6, s.length()), "Bob");
        test(s ->
                checkPositionIndex(6, s.length()), null);
        System.out.println("=======");
        System.out.println("=======");
        System.out.println("=======");
        // TODO: 2021/9/1 checkPositionIndexes(start,end,a) 检查 strat 到 end 是 a 的有效子列表
        test(s -> checkPositionIndexes(
                0, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(
                0, 10, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(
                0, 11, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(
                -1, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(
                7, 6, s.length()), "Hieronymus");
        test(s -> checkPositionIndexes(
                0, 6, s.length()), null);
    }
}
/* Output:
X
Success
null
NullPointerException
null
NullPointerException: s was null
null
NullPointerException: s was null, arg2 arg3
Fozzie
Success
X
IllegalArgumentException
null
IllegalArgumentException
null
IllegalArgumentException: Bear Left!
null
IllegalArgumentException: Bear Left! Frog Right!
Mortimer
Success
Mort
IllegalStateException
null
NullPointerException
Robert
IndexOutOfBoundsException: index (6) must be less than
size (6)
Bob
IndexOutOfBoundsException: index (6) must be less than
size (3)
null
NullPointerException
Robert
Success
Bob
IndexOutOfBoundsException: index (6) must not be
greater than size (3)
null
NullPointerException
Hieronymus
Success
Hieronymus
Success
Hieronymus
IndexOutOfBoundsException: end index (11) must not be
greater than size (10)
Hieronymus
IndexOutOfBoundsException: start index (-1) must not be
negative
Hieronymus
IndexOutOfBoundsException: end index (6) must not be
less than start index (7)
null
NullPointerException
*/
