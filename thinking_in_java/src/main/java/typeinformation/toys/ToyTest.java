// reflection/toys/ToyTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Testing class Class
// {java reflection.toys.ToyTest}
package typeinformation.toys;

// 有电池
interface HasBatteries {
}

// 防水的
interface Waterproof {
}

// 射击
interface Shoots {
}

// 玩具
class Toy {
    // Comment out the following zero-argument
    // constructor to see NoSuchMethodError
    public Toy() {
    }

    public Toy(int i) {
    }
}

// 花式玩具
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println(
                "Simple name: " + cc.getSimpleName());
        System.out.println(
                "Canonical name : " + cc.getCanonicalName());
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinformation.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        System.out.println("=======");
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        System.out.println("=======");
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // TODO: 2021/8/26 使用 newInstance()创建对象，对象本身必须具有无参数构造器
            // Requires public zero-argument constructor:
            obj = up.newInstance();
        } catch (Exception e) {
            throw new
                    RuntimeException("Cannot instantiate");
        }
        System.out.println("=======");
        printInfo(obj.getClass());
    }
}
/* Output:
Class name: reflection.toys.FancyToy is interface?
[false]
Simple name: FancyToy
Canonical name : reflection.toys.FancyToy
Class name: reflection.toys.HasBatteries is interface?
[true]
Simple name: HasBatteries
Canonical name : reflection.toys.HasBatteries
Class name: reflection.toys.Waterproof is interface?
[true]
Simple name: Waterproof
Canonical name : reflection.toys.Waterproof
Class name: reflection.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name : reflection.toys.Shoots
Class name: reflection.toys.Toy is interface? [false]
Simple name: Toy
Canonical name : reflection.toys.Toy
*/
