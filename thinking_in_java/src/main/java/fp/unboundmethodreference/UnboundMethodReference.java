package fp.unboundmethodreference;// functional/UnboundMethodReference.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Method reference without an object

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {

    public static void main(String[] args) {
        // MakeString ms = X::f;  不可以使用，因为需要绑定方法引用              // [1]
        MakeString makeString = new MakeString() {
            @Override
            public String make() {
                return "hah";
            }
        };
        System.out.println(makeString.make());

        //  TransformX sp = X::f; 和下面表达的意思是一样的
        TransformX sp = new TransformX() {
            @Override
            public String transform(X x) {
                return x.f();
            }
        };

        X x = new X();
        System.out.println(sp.transform(x));    // [2]
        System.out.println(x.f()); // Same effect
    }
}
/* Output:
X::f()
X::f()
*/
