package fp.constructfunctional;// functional/CtorReference.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Dog {
    String name;
    int age = -1; // For "unknown"

    Dog() {
        name = "stray";
    }

    Dog(String nm) {
        name = nm;
    }

    Dog(String nm, int yrs) {
        name = nm;
        age = yrs;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

public class CtorReference {

    public static void main(String[] args) {
       MakeNoArgs makeNoArgs = Dog::new;
       Make1Arg make1Arg = Dog::new;
       Make2Args make2Args = Dog::new;

       Dog noArgs = makeNoArgs.make();
       Dog args1 = make1Arg.make("ha");
       Dog args2= make2Args.make("11",2);

    }
}
