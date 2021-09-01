package stream.terminal;// streams/Informational.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import stream.readfilesforwords.FileToWords;

import java.util.stream.*;
import java.util.function.*;

public class Informational {
    
    public static void main(String[] args) throws Exception {
        
        System.out.println(FileToWords.stream("src/main/resources/Cheese.dat").count());
        
        System.out.println(FileToWords.stream("src/main/resources/Cheese.dat")
                        .min(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));
        
        System.out.println(FileToWords.stream("src/main/resources/Cheese.dat")
                        .max(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));

    }
}
/* Output:
32
a
you
*/
