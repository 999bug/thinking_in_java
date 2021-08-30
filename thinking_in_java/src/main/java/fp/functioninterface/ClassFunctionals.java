package fp.functioninterface;// functional/ClassFunctionals.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;
import java.util.function.*;

class AA {}
class BB {}
class CC {}

// TODO: 2021/8/30  函数式接口的使用
public class ClassFunctionals {
  static AA f1() { return new AA(); }

  static int f2(AA aa1, AA aa2) { return 1; }

  static void f3(AA aa) {}

  static void f4(AA aa, BB bb) {}

  static CC f5(AA aa) { return new CC(); }

  static CC f6(AA aa, BB bb) { return new CC(); }

  static boolean f7(AA aa) { return true; }

  static boolean f8(AA aa, BB bb) { return true; }

  static AA f9(AA aa) { return new AA(); }

  static AA f10(AA aa1, AA aa2) { return new AA(); }

  public static void main(String[] args) {
    Supplier<AA> s = ClassFunctionals::f1;
    System.out.println(s.get());

    Comparator<AA> c = ClassFunctionals::f2;
    c.compare(new AA(), new AA());

    Consumer<AA> cons = ClassFunctionals::f3;
    cons.accept(new AA());

    //接收2个参数
    BiConsumer<AA,BB> bicons = ClassFunctionals::f4;
    bicons.accept(new AA(), new BB());

    Function<AA,CC> f = ClassFunctionals::f5;
    CC cc = f.apply(new AA());

    BiFunction<AA,BB,CC> bif = ClassFunctionals::f6;
    cc = bif.apply(new AA(), new BB());

    Predicate<AA> p = ClassFunctionals::f7;
    boolean result = p.test(new AA());

    BiPredicate<AA,BB> bip = ClassFunctionals::f8;
    result = bip.test(new AA(), new BB());

    // 如果返回值类型与参数类型一致，则是一个运算符：单个参数使用 UnaryOperator，
    UnaryOperator<AA> uo = ClassFunctionals::f9;
    AA aa = uo.apply(new AA());
    
    //如果返回值类型与参数类型一致，则是一个运算符：两个参数使用 BinaryOperator。
    BinaryOperator<AA> bo = ClassFunctionals::f10;
    aa = bo.apply(new AA(), new AA());
  }
}
