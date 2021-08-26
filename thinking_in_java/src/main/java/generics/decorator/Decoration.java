// generics/decorator/Decoration.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java generics.decorator.Decoration}
package generics.decorator;

import java.util.*;

class Basic1 {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic1 {
    protected Basic1 basic;

    Decorator(Basic1 basic) {
        this.basic = basic;
    }

    @Override
    public void set(String val) {
        basic.set(val);
    }

    @Override
    public String get() {
        return basic.get();
    }
}

class TimeStamped1 extends Decorator {
    private final long timeStamp;

    TimeStamped1(Basic1 basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumbered1 extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    SerialNumbered1(Basic1 basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStamped1 t = new TimeStamped1(new Basic1());
        TimeStamped1 t2 = new TimeStamped1(
                new SerialNumbered1(new Basic1()));
        //- t2.getSerialNumber(); // Not available
        SerialNumbered1 s = new SerialNumbered1(new Basic1());
        SerialNumbered1 s2 = new SerialNumbered1(
                new TimeStamped1(new Basic1()));
        //- s2.getStamp(); // Not available
    }
}
