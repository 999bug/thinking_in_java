package fp.unboundmethodreference;// functional/MethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface Callable {                        // [1]
    void call(String s);
}

class Describe {
    void show(String msg) {                   // [2]
        System.out.println(msg);
    }
}

public class MethodReferences {

    static void hello(String name) {          // [3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {                 // [4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {        // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        // 简单理解 映射，将describe.show() 映射给 Callable.call() 方法上
        Callable c = d::show;                   // [6]
        // 通过调用 call() 来调用 show(), java 将call() 映射到show()
        c.call("call()");                       // [7]

        c = MethodReferences::hello;            // [8]
        c.call("Bob");
        // 映射：将Description.help()方法映射到 Callable.call() 上
        c = new Description("valuable")::help;  // [9]
        c.call("information");

        c = Helper::assist;                     // [10]
        c.call("Help!");
    }
}
/* Output:
call()
Hello, Bob
valuable information
Help!
*/