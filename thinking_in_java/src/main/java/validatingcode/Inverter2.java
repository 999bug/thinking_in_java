package validatingcode;// validating/Inverter2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import static java.lang.Character.*;

public class Inverter2 implements StringInverter {
    @Override
    public String invert(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.append(isUpperCase(c) ? toLowerCase(c) : toUpperCase(c));
        }
        return result.toString();
    }
}
